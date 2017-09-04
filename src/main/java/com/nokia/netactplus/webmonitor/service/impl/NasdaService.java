package com.nokia.netactplus.webmonitor.service.impl;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.nokia.netactplus.webmonitor.constant.InterfaceProperties;
import com.nokia.netactplus.webmonitor.dao.Connect2OracleFactory;
import com.nokia.netactplus.webmonitor.dao.NetActDataDao;
import com.nokia.netactplus.webmonitor.entity.NASDA_OBJECTS;
import com.nokia.netactplus.webmonitor.service.INasdaService;

@Service
public class NasdaService implements INasdaService {

	@Autowired
	private Connect2OracleFactory connect2OracleFactory;

	@Autowired
	private NetActDataDao netActDataDao;

	@SuppressWarnings("unchecked")
	@Override
	public List<NASDA_OBJECTS> getNasdaMOs(String dbIpv4, String condition) {
		Connection conn = connect2OracleFactory.getDBConnection(dbIpv4);
		List<NASDA_OBJECTS> objects = (List<NASDA_OBJECTS>) netActDataDao.selectObjects("NASDA_OBJECTS", condition, conn, null);
		return objects;
	}
	
	
	@SuppressWarnings("unchecked")
	@Cacheable(value = "nasdaClassCache", key = "#dbIpv4")
	@Override
	public Map<Object, Map<String, Object>> getNasdaObjectClass(String dbIpv4) {
			return netActDataDao.executeQuery("SELECT OC_ID,OC_NAME,OC_ADAPTATION FROM NASDA_OBJECT_CLASS",
					"OC_ID", connect2OracleFactory.getDBConnection(dbIpv4));
	}
	
	@Override
	public List<Map<String, Object>> getNasdaObjects(String dbIpv4) {
		Connection conn = connect2OracleFactory.getDBConnection(dbIpv4);
		String sql=" SELECT CO_GID, CO_OC_ID, CO_SYS_VERSION, CO_PARENT_GID, CO_DN,CO_OBJECT_INSTANCE   FROM NASDA_OBJECTS";
			return  netActDataDao.executeQuery(sql, conn);
	}
	
	public	Map<Object,Map<String, Object>> getFmAlarmStates(String dbIpv4)
	{
		String sql="SELECT ID, LAST_UPDATE_TIMESTAMP, MAX_ALARM_SEVERITY, ACK_STATE, CRITICALS_CNT, MAJORS_CNT, MINORS_CNT, WARNINGS_CNT, NONACKS_CNT FROM FM.FM_ALARM_STATES A WHERE EXISTS (SELECT 1 FROM NASDA_OBJECTS B WHERE B.CO_GID=A.ID)";
		return  netActDataDao.executeQuery(sql, "ID", connect2OracleFactory.getDBConnection(dbIpv4));
	}

	@Override
	public	Map<Object,Map<String, Object>> getObjectClassMeta(String dbIpv4)
	{
		String sql="SELECT OBJECT_CLASS, ADAPTATION_ID, ADAPTATION_RELEASE FROM FM.FM_OBJECT_CLASS_META";
		return  netActDataDao.executeQuery(sql, "OBJECT_CLASS",connect2OracleFactory.getDBConnection(dbIpv4));
	}

	@Override
	public	List<Map<String, Object>> getInterfaceObjects(String dbIpv4)
	{
		String sql="SELECT A.OC_NAME FROM NASDA_OBJECT_CLASS A "
				+ " WHERE A.OC_ADAPTATION='com.nsn.netact.nasda.interfaces' "
					+ " AND EXISTS (SELECT  1 FROM NASDA_OBJECTS B WHERE B.CO_OC_ID=A.OC_ID)";
	return  netActDataDao.executeQuery(sql, connect2OracleFactory.getDBConnection(dbIpv4));
	}
	
	@Override
	public	Map<Object,Map<String, Object>> getNasdaRefAgent(String dbIpv4)
	{
		String sql="select MO_GID, AGENT_GID from NASDA_REF_AGENT where AGENT_GID=  MO_GID";
		return  netActDataDao.executeQuery(sql,"MO_GID", connect2OracleFactory.getDBConnection(dbIpv4));
	}
	
	@Override
	public	Map<Object,Map<String, Object>> getNasdaRefMr(String dbIpv4)
	{
		String sql="select MO_GID,MR_GID from NASDA_REF_MR";
		return  netActDataDao.executeQuery(sql,"MO_GID", connect2OracleFactory.getDBConnection(dbIpv4));
	}
	
	@Override
	public	Map<Object, Map<String, Object>> getInterfaceProperty(String dbIpv4, String InterfaceName)
	{
		String object_name="";
		if(InterfaceProperties.PropertiesObject.containsKey(InterfaceName))
		{
			object_name=InterfaceProperties.PropertiesObject.get(InterfaceName);
		}
		else
		{
			object_name="ND_IN_"+InterfaceName;
		}
		return  netActDataDao.executeQuery("SELECT * FROM "+object_name,"OBJ_GID", connect2OracleFactory.getDBConnection(dbIpv4));
	}
}
