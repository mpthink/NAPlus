package com.nokia.netactplus.webmonitor.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.kisso.SSOHelper;
import com.baomidou.kisso.SSOToken;
import com.baomidou.mybatisplus.plugins.Page;
import com.nokia.netactplus.common.controller.SuperController;
import com.nokia.netactplus.system.entity.NetactLab;
import com.nokia.netactplus.system.mapper.NetactLabMapper;
import com.nokia.netactplus.webmonitor.service.IFMService;


@Controller
@RequestMapping("/webmonitor/fm")
public class FMController extends SuperController {
	private final static Logger LOGGER = LoggerFactory.getLogger(FMController.class);

	@Autowired
	private IFMService fmService;

	@Autowired
	private NetactLabMapper netactLabMapper;

	@RequestMapping("/alarm/list/{labName}/{alarmType}/{dn}")
	@ResponseBody
	public String listAlarms(@PathVariable("labName") String labName, @PathVariable("alarmType") int alarmType, @PathVariable("dn") String dn) {
		try {
			dn = URLDecoder.decode(dn, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Page<Map<String,Object>> page = getPageForBootstrapTable();
		NetactLab netactLab = new NetactLab();
		netactLab.setLabName(labName);
		netactLab = netactLabMapper.selectOne(netactLab);
		String dbHost = netactLab.getDbIpv4();
		String dbRootPwd = netactLab.getRootPassword();
		String condition = "";
		String orderCase=" ORDER BY CONSEC_NBR DESC ";
		switch (alarmType) {
			case 1://history alarm
				condition = " where LIFTED_DN like'" + dn + "/%' or LIFTED_DN='"+dn+"'";
				break;
			case 2://warning alarm
				condition = " where (LIFTED_DN like'" + dn + "/%' or LIFTED_DN='"+dn+"') and SEVERITY = 4";
				break;
			case 3://active alarm
				condition = "where (LIFTED_DN like'" + dn + "/%' or LIFTED_DN='"+dn+"')  and ALARM_STATUS = 1";
				break;
			case 4://alarm upload
				return toJson(fmService.tiggerUpload(dbHost, dbRootPwd, dn));
			default:
				condition = " where LIFTED_DN like'" + dn + "/%' or LIFTED_DN='"+dn+"'";
		}
		return toJson(fmService.selectAlarmsByPage(page, dbHost, condition, orderCase));
	}
	
	@RequestMapping("/alarm/delegat")
	@ResponseBody
	public String alarmDelegat()
	{
		NetactLab netactLab = new NetactLab();
		String labName = request.getParameter("labName");
		netactLab.setLabName(labName);
		netactLab = netactLabMapper.selectOne(netactLab);
		String alarmKey = request.getParameter("alarmKey");
		String type = request.getParameter("opt");
		SSOToken token=(SSOToken) SSOHelper.getToken(request);
		LOGGER.debug("labName:"+labName+", type:"+type+", alarm:"+alarmKey+", userId:"+token.getData());
		List<Long>alarmKeys=new ArrayList<Long>();
		alarmKeys.add(Long.parseLong(alarmKey));
		int failedCount=fmService.alarmDelegateByKeys(type,netactLab, alarmKeys,token.getData());
		if(failedCount> 0)
		{
			return type +" faied count:"+failedCount;
		}
		return "Ok";
	}
}
