package com.nokia.netactplus.webmonitor.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nokia.netactplus.common.controller.SuperController;
import com.nokia.netactplus.system.entity.NetactLab;
import com.nokia.netactplus.system.mapper.NetactLabMapper;
import com.nokia.netactplus.webmonitor.constant.InterfaceProperties;
import com.nokia.netactplus.webmonitor.service.ICreateMOService;
import com.nokia.netactplus.webmonitor.service.INasdaService;
import com.nsn.oss.nasda.access.irp.ws.persistency.model.Relationship;

@Controller
@RequestMapping("/webmonitor/nasda")
public class NasdaController extends SuperController {
	private final static Logger LOGGER = LoggerFactory.getLogger(NasdaController.class);

	@Autowired
	private INasdaService nasdaService;
	
	@Autowired
	private ICreateMOService createMOService;

	@Autowired
	private NetactLabMapper netactLabMapper;

	@RequestMapping("/motree/{labName}")
	@ResponseBody
	public String listMOTree(@PathVariable String labName) {
		List<Map<String, Object>> treeData = new ArrayList<Map<String, Object>>();
		NetactLab netactLab = new NetactLab();
		netactLab.setLabName(labName);
		netactLab = netactLabMapper.selectOne(netactLab);
		
		List<Map<String,Object>> nasdaobjs = nasdaService.getNasdaObjects(netactLab.getDbIpv4());

		for (Map<String,Object> obj : nasdaobjs) {
			Map<String, Object> element = new HashMap<>();
			element.put("id", obj.get("CO_GID"));
			element.put("pId", obj.get("CO_PARENT_GID"));
			element.put("name", obj.get("CO_DN").toString().replaceAll(".*/", ""));
			element.put("title", obj.get("CO_DN"));
			element.put("ocId", obj.get("CO_OC_ID"));
			element.put("objInstance", obj.get("CO_OBJECT_INSTANCE"));
			element.put("version", obj.get("CO_SYS_VERSION"));

			//默认展开树
			element.put("open", "true");
			treeData.add(element);
		}

		return toJson(treeData);
	}
	
		
	@RequestMapping("/objectdata/{labName}")
	@ResponseBody
	public String getObjectData(@PathVariable("labName") String labName) {
		NetactLab netactLab = new NetactLab();
		netactLab.setLabName(labName);
		netactLab = netactLabMapper.selectOne(netactLab);
		LOGGER.debug("getObjectData, labname:"+labName);
		Map<Object,Map<String, Object>>  interfaceMap =new HashMap<Object,Map<String, Object>>();
		
		List<Map<String, Object>> interfaceObjects =	nasdaService.getInterfaceObjects(netactLab.getDbIpv4());
		for (Map<String,Object> obj : interfaceObjects) {
			interfaceMap.putAll(nasdaService.getInterfaceProperty(netactLab.getDbIpv4(),obj.get("OC_NAME").toString()));
		}
		
		Map<String, Object> retMap=new HashMap<String, Object>();
		retMap.put("interfaceMap", interfaceMap);
		retMap.put("objClassMetaMap", nasdaService.getObjectClassMeta(netactLab.getDbIpv4()));
		retMap.put("alarmStatesMap", nasdaService.getFmAlarmStates(netactLab.getDbIpv4()));
		retMap.put("nasdaObjectClassMap", nasdaService.getNasdaObjectClass(netactLab.getDbIpv4()));
		retMap.put("nasdaRefAgentMap", nasdaService.getNasdaRefAgent(netactLab.getDbIpv4()));
		retMap.put("nasdaRefMrMap", nasdaService.getNasdaRefMr(netactLab.getDbIpv4()));
		return toJsonWithMapNullVal(retMap);
	}
	
	
	@RequestMapping("/createMO/{dnType}")
	public String creatMO(@PathVariable("dnType") String dnType, Model model) {
		LOGGER.debug("Prepare Create Object, dnType:"+dnType);
		model.addAttribute("dnType", dnType);

		return "/netact/monitor/createobj";
	}
	
	/**
	 * 执行编辑
	 */
	@RequestMapping("/doCreatMO/{objType}")
	@ResponseBody
	public String doCreatMO(@PathVariable("objType") String objType) {
		NetactLab netactLab = new NetactLab();
		netactLab.setLabName(request.getParameter("labName"));
		netactLab = netactLabMapper.selectOne(netactLab);
		String dn = request.getParameter("dn");
		String instanceId = request.getParameter("instance_id");
		int retCode = 0;
		String objectClass=null;
		Map<String, String> paramMap = null;
		Relationship relationship = null;
				
		if (objType.equals("PLMN")) {
			dn = "PLMN-" + instanceId;
		} 
		else if (objType.equals("MO"))
		{
			
			dn += "/" + request.getParameter("ManagedObject") + "-" + instanceId;
			paramMap = new HashMap<String, String>();
			paramMap.put("version", request.getParameter("version"));
			paramMap.put("directIntegration", "true");

			if(request.getParameter("isAgent")!=null && request.getParameter("isAgent").equals("on")){
				relationship = new Relationship();
				relationship.setRelationshipId("AGENT");
				relationship.setSourceMOId(dn);
				relationship.setTargetMOId(dn);
			}			
		}
		else if (objType.equals("IF")) 
		{
			objectClass=request.getParameter("IfObjectSel");
			dn += "/" + objectClass + "-" + instanceId;
			
//			Enumeration<String> paraNames=request.getParameterNames();
//			for(Enumeration e=paraNames;e.hasMoreElements();){
//
//			       String thisName=e.nextElement().toString();
//			       String thisValue=request.getParameter(thisName);
//			       LOGGER.debug(thisName+"--------------"+thisValue);
//
//			}
			paramMap = new HashMap<String, String>();
			
			Iterator<Map.Entry<String, String>> entries = null;
			Map.Entry<String, String> entry=null;
			if(objectClass.equals("NE3SWS"))
			{
				entries=InterfaceProperties.NE3SWSProperties.entrySet().iterator();
			}
			else if(objectClass.equals("SSH"))
			{
				entries=InterfaceProperties.SSHProperties.entrySet().iterator();
			}
			else if(objectClass.equals("SNMP"))
			{
				entries=InterfaceProperties.SNMPProperties.entrySet().iterator();
			}
			else if(objectClass.equals("FTP"))
			{
				entries=InterfaceProperties.FTPProperties.entrySet().iterator();
			}
			else if(objectClass.equals("HTTP"))
			{
				entries=InterfaceProperties.HTTPProperties.entrySet().iterator();
			}
			else 
			{
				return "Unknown interface";
			}
			
			while (entries.hasNext()) {  
				  
				entry = entries.next();  	  
			    if(request.getParameter(entry.getKey())!=null)
			    {
			    	paramMap.put(entry.getKey(), request.getParameter(entry.getKey()));
			    }
			    else if(!entry.getValue().isEmpty())
			    {
				    paramMap.put(entry.getKey(), entry.getValue());
			    }
			}
			LOGGER.debug("interface = " + objectClass+" paramMap begin\n" + paramMap+"\n"+"interface = " + objectClass+ " paramMap end");
			
		}
		else // MRC/MR
		{
			if (!dn.startsWith("MRC-")) {
				dn = "MRC-" + instanceId;
			} else {
				dn += "/MR-" + instanceId;
			}
		}
 		
		LOGGER.debug("Create Object, dn:" + dn+",objType:"+objType);
		retCode = createMOService.createMO(netactLab, dn, paramMap);
		if (retCode != 0) {
			return "Create MO failed";
		}
		if(relationship!=null)
		{
			retCode = createMOService.createRelationship(netactLab, relationship);
		}
	
		if (retCode == 0) {
			return "Ok";
		} else {
			return "Create MO failed";
		}
	}
	
	@RequestMapping("/updateMr/{labName}")
	@ResponseBody
	public String updateMr(@PathVariable("labName") String labName) {
		NetactLab netactLab = new NetactLab();
		netactLab.setLabName(labName);
		netactLab = netactLabMapper.selectOne(netactLab);
		String dn=request.getParameter("dn");
		String mrDn=request.getParameter("mrDn");
		String oldMrDn=request.getParameter("oldMrDn");
		LOGGER.debug("updateMr, labName="+labName+", dn=" + dn + ", mrDn="+ mrDn+",oldMrDn="+oldMrDn);
		
		Relationship relationship = new Relationship();
		relationship.setRelationshipId("MR");
		relationship.setSourceMOId(dn);
		relationship.setTargetMOId(mrDn);

		//int retCode = createMOService.updateRelationship(netactLab, relationship);
		int retCode = createMOService.updateMrRelationship(netactLab, relationship, oldMrDn);

		if (retCode == 0) {
			return "Ok";
		} else {
			return "Update MR relationship failed";
		}
	}
	
	@RequestMapping("/updateMO/{labName}")
	@ResponseBody
	public String updateMO(@PathVariable("labName") String labName) {
		NetactLab netactLab = new NetactLab();
		netactLab.setLabName(labName);
		netactLab = netactLabMapper.selectOne(netactLab);
		String dn=request.getParameter("dn");
		String objectClass= request.getParameter("objectClass");
	
		Map<String, String> paramMap = new HashMap<String, String>();
		Iterator<Map.Entry<String, String>> entries = null;
		Map.Entry<String, String> entry=null;
		if(objectClass.equals("NE3SWS"))
		{
			entries=InterfaceProperties.NE3SWSProperties.entrySet().iterator();
		}
		else if(objectClass.equals("SSH"))
		{
			entries=InterfaceProperties.SSHProperties.entrySet().iterator();
		}
		else if(objectClass.equals("SNMP"))
		{
			entries=InterfaceProperties.SNMPProperties.entrySet().iterator();
		}
		else if(objectClass.equals("FTP"))
		{
			entries=InterfaceProperties.FTPProperties.entrySet().iterator();
		}
		else if(objectClass.equals("HTTP"))
		{
			entries=InterfaceProperties.HTTPProperties.entrySet().iterator();
		}
		else 
		{
			return "Unknown interface";
		}
		
		while (entries.hasNext()) {  
			  
			entry = entries.next();  	  
		    if(request.getParameter(entry.getKey())!=null)
		    {
		    	paramMap.put(entry.getKey(), request.getParameter(entry.getKey()));
		    }
		    else if(!entry.getValue().isEmpty())
		    {
			    paramMap.put(entry.getKey(), entry.getValue());
		    }
		}
		LOGGER.debug("updateMO, interface = " + objectClass+" paramMap begin\n" + paramMap+"\n"+"interface = " + objectClass+ " paramMap end");
		
		int retCode = createMOService.updateMO(netactLab, dn, paramMap);

		if (retCode == 0) {
			return "Ok";
		} else {
			return "Update MR relationship failed";
		}
	}
	
}
