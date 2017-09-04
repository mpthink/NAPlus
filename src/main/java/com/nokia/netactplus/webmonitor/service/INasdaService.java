package com.nokia.netactplus.webmonitor.service;

import java.util.List;
import java.util.Map;

import com.nokia.netactplus.webmonitor.entity.NASDA_OBJECTS;
import com.nokia.netactplus.webmonitor.entity.NASDA_OBJECT_CLASS;

public interface INasdaService {

	List<NASDA_OBJECTS> getNasdaMOs(String host, String condition);
	
	Map<Object, Map<String, Object>> getNasdaObjectClass(String dbIpv4);

	List<Map<String, Object>> getNasdaObjects(String dbIpv4);

	Map<Object, Map<String, Object>> getObjectClassMeta(String dbIpv4);

	Map<Object, Map<String, Object>> getFmAlarmStates(String dbIpv4);

	Map<Object, Map<String, Object>> getInterfaceProperty(String dbIpv4, String InterfaceName);

	List<Map<String, Object>> getInterfaceObjects(String dbIpv4);

	Map<Object, Map<String, Object>> getNasdaRefMr(String dbIpv4);

	Map<Object, Map<String, Object>> getNasdaRefAgent(String dbIpv4);

}
