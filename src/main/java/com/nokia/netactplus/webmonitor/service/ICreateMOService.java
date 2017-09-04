package com.nokia.netactplus.webmonitor.service;

import java.util.Map;

import com.nokia.netactplus.system.entity.NetactLab;
import com.nsn.oss.nasda.access.irp.ws.persistency.model.Relationship;

public interface ICreateMOService {
	
	Map<String, String> getNasdaObjectClassMap(String dbIpv4);
	
	int createMO(NetactLab netactLab, String dn, Map<String, String>paramMap);
	int createRelationship(NetactLab netactLab, Relationship relationship);

	int deleteRelationship(NetactLab netactLab, Relationship relationship);

	int updateRelationship(NetactLab netactLab, Relationship relationship);

	int updateMO(NetactLab netactLab, String dn, Map<String, String> paramMap);

	int updateMrRelationship(NetactLab netactLab, Relationship relationship, String oldMrDn);

}
