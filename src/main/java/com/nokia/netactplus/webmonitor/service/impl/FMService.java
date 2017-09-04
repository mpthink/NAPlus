package com.nokia.netactplus.webmonitor.service.impl;

import java.net.URL;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.nokia.netactplus.webmonitor.dao.Connect2OracleFactory;
import com.nokia.netactplus.webmonitor.dao.NetActDataDao;
import com.nokia.netactplus.webmonitor.service.IFMService;
import com.nokia.oss.fmaccess.service.impl.AlarmDelegateService;
import com.nokia.oss.interfaces.fmaccess.service.AlarmDelegateSEI;
import com.nokia.oss.interfaces.fmaccess.service.AlarmKeyResult;
import com.nokia.oss.interfaces.fmaccess.service.NsnAlarmKey;
import com.nokia.netactplus.common.ssh.SshBasic;
import com.nokia.netactplus.system.entity.NetactLab;


@Service
public class FMService implements IFMService {

	@Autowired
	private Connect2OracleFactory connect2OracleFactory;
	
	@Autowired
	private SshBasic ssh2NetAct;
	
	@Autowired
	private NetActDataDao netActDataDao;

	@SuppressWarnings("unchecked")
	@Override
	public Page<Map<String,Object>> selectAlarmsByPage(Page<Map<String,Object>> page, String host, String condition, String orderCase) {
		Connection conn = connect2OracleFactory.getDBConnection(host);
		String className = "FX_ALARM";
		int offsetCurrent = page.getOffsetCurrent();
		int size = page.getSize();
		if (condition == null) {
			condition = "";
		}
		int total = netActDataDao.getTotalRows(className, condition, conn);
		page.setTotal(total);
		
		String pagination = " where rn between " + Integer.toString(offsetCurrent + 1) + " and " + Integer.toString(offsetCurrent + size);
		String sql = "select c.* from (select b.*,rownum rn from (select * from FX_ALARM a  %s) b ) c";
		sql = String.format(sql, condition+orderCase);
		sql +=pagination;

		List<Map<String,Object>> alarms = (List<Map<String,Object>>) netActDataDao.executeQuery(sql, conn);
		page.setRecords(alarms);
		return page;
	}

	
	public Boolean tiggerUpload(String host, String dbRootPwd, String dn) {
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		String formatdn = dn.replaceAll("/","%2F");
		StringBuffer sb=new StringBuffer();
		sb.append("<?xml version=\\\"1.0\\\"?>\n");
		sb.append("<notification>\n");
		sb.append("        <alarmNew  systemDN=\\\""+ dn + "\\\">\n");
		sb.append("                <eventTime>"+ time +"</eventTime>\n");
		sb.append("                <specificProblem>2147483647</specificProblem>\n");
		sb.append("                <alarmText>alarm text for auto-integration-framework to trigger AU</alarmText>\n");
		sb.append("                <perceivedSeverity>major</perceivedSeverity>\n");
		sb.append("                <eventType>communication</eventType>\n");
		sb.append("                <probableCause>1234</probableCause>\n");
		sb.append("                <alarmId>136135069144</alarmId>\n");
		sb.append("                <additionalText1>supp info for auto-integration-framework</additionalText1>\n");
		sb.append("                <additionalText2>user info for auto-integration-framework</additionalText2>\n");
		sb.append("                <additionalText3>diag info for auto-integration-framework</additionalText3>\n");
		sb.append("        </alarmNew>\n");
		sb.append("</notification>");
		
		int random = new Random().nextInt();
		String fileBaseName = "an_fqdn_"+ formatdn + "_"+ random + ".xml";
		String fileName = "/tmp/" + fileBaseName;
		String fmImportDir = "/var/opt/nokia/oss/global/mediation/south/fm/import/";
		String fileInProgress = fmImportDir + fileBaseName + ".in-progress";
		String fileInFM = fmImportDir + fileBaseName;
		String cmd[] = {"echo \"" + sb + "\" > "+ fileName,
				"chmod 666 " + fileName + "; mv " + fileName + " " + fileInProgress + "; mv "+ fileInProgress + " " + fileInFM};

		ch.ethz.ssh2.Connection conn = ssh2NetAct.login(host, 22, "root", dbRootPwd);
		ssh2NetAct.exeCmd(conn, cmd[0]);
		ssh2NetAct.exeCmd(conn, cmd[1]);
		conn.close();
		return true;
	}
	
	private AlarmDelegateSEI initFMAcessWS(NetactLab netactLab) throws Exception {
		String fmAccessUrl = "http://%s/fmAccess/services/alarmDelegateService?wsdl";
		fmAccessUrl = String.format(fmAccessUrl, netactLab.getLbwasIpv4());
		AlarmDelegateService alarmDelgateService = new AlarmDelegateService(new URL(fmAccessUrl));
		AlarmDelegateSEI alarmDelegatePort = alarmDelgateService.getAlarmDelegatePort();
		((BindingProvider) alarmDelegatePort).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
		((BindingProvider) alarmDelegatePort).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "omc");
		((BindingProvider) alarmDelegatePort).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, netactLab.getOmcPassword());
		return alarmDelegatePort;
	}

	private List<NsnAlarmKey> list2NsnAlarmKeyList(List<Long> ids)
	{
		List<NsnAlarmKey> alarmKeys = new ArrayList<NsnAlarmKey>();
		for (Long id : ids) {
			NsnAlarmKey nk = new NsnAlarmKey();
			nk.setAlarmId(id);
			alarmKeys.add(nk);
		}
		return alarmKeys;
	}
	
	@Override
	public int alarmDelegateByKeys(String type, NetactLab netactLab, List<Long> alarmKeys,String userId)
	{
		AlarmDelegateSEI alarmDelegate = null;
		List<AlarmKeyResult> alarmKeyResults = null;
		int failedCnt=0;
		try {
			alarmDelegate = initFMAcessWS(netactLab);
			if(type.equals("Ack")){
				alarmKeyResults = alarmDelegate.acknowledgeAlarmsByKeys(list2NsnAlarmKeyList(alarmKeys), userId, null);
			}else if(type.equals("UnAck")){
				alarmKeyResults = alarmDelegate.unAcknowledgeAlarmsByKeys(list2NsnAlarmKeyList(alarmKeys), userId, null);
			}else if(type.equals("Clear")){
				alarmKeyResults = alarmDelegate.clearAlarmsByKeys(list2NsnAlarmKeyList(alarmKeys), userId, null);
			}
			
			for (AlarmKeyResult alarmKeyResult: alarmKeyResults)
			{
				if(!alarmKeyResult.isSuccess())
				{
					failedCnt+=1;
				}
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return failedCnt;
	}
	
}
