package com.nokia.netactplus.webmonitor.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nokia.netactplus.system.entity.NetactLab;
import com.nokia.netactplus.webmonitor.service.ICreateMOService;
import com.nokia.netactplus.webmonitor.service.INasdaService;
import com.nsn.oss.nasda.access.irp.ws.persistency.NasdaWSPersistencyPortType;
import com.nsn.oss.nasda.access.irp.ws.persistency.NasdaWSPersistencyServiceSOAP;
import com.nsn.oss.nasda.access.irp.ws.persistency.model.MOLite;
import com.nsn.oss.nasda.access.irp.ws.persistency.model.ManagedObject;
import com.nsn.oss.nasda.access.irp.ws.persistency.model.P;
import com.nsn.oss.nasda.access.irp.ws.persistency.model.Relationship;
import com.nsn.oss.nasda.access.irp.ws.persistency.operations.CreateMOsRequest;
import com.nsn.oss.nasda.access.irp.ws.persistency.operations.CreateMOsResponse;
import com.nsn.oss.nasda.access.irp.ws.persistency.operations.GetRelatedMOLitesRequest;
import com.nsn.oss.nasda.access.irp.ws.persistency.operations.GetRelatedMOLitesResponse;
import com.nsn.oss.nasda.access.irp.ws.persistency.operations.RelationshipsRequest;
import com.nsn.oss.nasda.access.irp.ws.persistency.operations.RelationshipsResponse;
import com.nsn.oss.nasda.access.irp.ws.persistency.operations.UpdateMOsRequest;
import com.nsn.oss.nasda.access.irp.ws.persistency.operations.UpdateMOsResponse;

@Service
public class CreateMOService implements ICreateMOService{
	private final static Logger LOGGER = LoggerFactory.getLogger(CreateMOService.class);
	
	@Autowired
	private INasdaService nasdaService;
	
	@Override
	public int updateMO(NetactLab netactLab, String dn, Map<String, String> paramMap) {
		NasdaWSPersistencyPortType port = initNasdaWS(netactLab);
		String targetMOClass = getObjectClass(dn);
		Map<String, String> nasdaClassMap = getNasdaObjectClassMap(netactLab.getDbIpv4());
		if (!checkMapKey(nasdaClassMap, targetMOClass)) {
			return 1;
		}
		List<ManagedObject> mos = new ArrayList<>();
		String moId = dn;
		String metaClass = nasdaClassMap.get(targetMOClass) + ":" + targetMOClass;
		List<P> params = new ArrayList<>();
		if (paramMap != null) {
			for (Map.Entry<String, String> entry : paramMap.entrySet()) {

//				LOGGER.debug("Key = " + entry.getKey() + ", Value = " + entry.getValue());
				P p = new P();
				p.setName(entry.getKey());
				p.setValue(entry.getValue());
				params.add(p);
			}
		}
		ManagedObject managedObject = generateMO(moId, metaClass, params);
		mos.add(managedObject);
		UpdateMOsRequest updateMOsRequest = new UpdateMOsRequest();
		updateMOsRequest.setManagedObject(mos);
		UpdateMOsResponse response = port.updateManagedObjects(updateMOsRequest);
		
		try
		{
			if (response.getResult().getBatchItemMOLiteResult().get(0).getErrorCode().equalsIgnoreCase("OK")) {
				return 0;
			} else {
				LOGGER.error("UpdateMOsResponse==="+response.getResult().getBatchItemMOLiteResult().get(0).getErrorCause());
				return 2;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 3;
		}		
	}
	
	@Override
	public int createMO(NetactLab netactLab, String dn, Map<String, String> paramMap) {
		NasdaWSPersistencyPortType port = initNasdaWS(netactLab);
		String targetMOClass = getObjectClass(dn);
		Map<String, String> nasdaClassMap = getNasdaObjectClassMap(netactLab.getDbIpv4());
		if (!checkMapKey(nasdaClassMap, targetMOClass)) {
			return 1;
		}
		List<ManagedObject> mos = new ArrayList<>();
		String moId = dn;
		String metaClass = nasdaClassMap.get(targetMOClass) + ":" + targetMOClass;
		List<P> params = new ArrayList<>();
		// Map<Integer, Integer> map = new HashMap<String, String>();
		if (paramMap != null) {
			for (Map.Entry<String, String> entry : paramMap.entrySet()) {

				LOGGER.debug("Key = " + entry.getKey() + ", Value = " + entry.getValue());
				P p = new P();
				p.setName(entry.getKey());
				p.setValue(entry.getValue());
				params.add(p);
			}
		}
		ManagedObject managedObject = generateMO(moId, metaClass, params);
		mos.add(managedObject);
		CreateMOsRequest createMOsRequest = new CreateMOsRequest();
		createMOsRequest.setManagedObject(mos);
		CreateMOsResponse response = port.createManagedObjects(createMOsRequest);
		
		try
		{
			if (response.getResult().getBatchItemMOLiteResult().get(0).getErrorCode().equalsIgnoreCase("OK")) {
				return 0;
			} else {
				LOGGER.error("CreateMOsResponse==="+response.getResult().getBatchItemMOLiteResult().get(0).getErrorCause());
				return 2;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 3;
		}		
	}


	@Override
	public int createRelationship(NetactLab netactLab, Relationship relationship) {
		
		if(relationship.getTargetMOId().isEmpty())
		{
			return 0;
		}
		NasdaWSPersistencyPortType port = initNasdaWS(netactLab);
		List<Relationship> relationships = new ArrayList<>();
		RelationshipsRequest relationshipsRequest = new RelationshipsRequest();
		relationships.add(relationship);
		relationshipsRequest.setRelationship(relationships);
		RelationshipsResponse response = port.createRelationships(relationshipsRequest);
		try
		{
			if (response.getResult().getBatchItemRelationshipResult().get(0).getErrorCode().equalsIgnoreCase("OK")) {
				return 0;
			} else {
				LOGGER.error("createRelationship Response==="+response.getResult().getBatchItemRelationshipResult().get(0).getErrorCause());
				return 2;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 3;
		}
	}
	
	
	@Override
	public int deleteRelationship(NetactLab netactLab, Relationship relationship) {
		NasdaWSPersistencyPortType port = initNasdaWS(netactLab);
		List<Relationship> relationships = new ArrayList<>();
		RelationshipsRequest relationshipsRequest = new RelationshipsRequest();
		relationships.add(relationship);
		relationshipsRequest.setRelationship(relationships);
		RelationshipsResponse response = port.deleteRelationships(relationshipsRequest);
		try
		{
			if (response.getResult().getBatchItemRelationshipResult().get(0).getErrorCode().equalsIgnoreCase("OK")) {
				return 0;
			} else {
				LOGGER.error("deleteRelationship Response==="+response.getResult().getBatchItemRelationshipResult().get(0).getErrorCause());
				return 2;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 3;
		}
	}
	
	private List<MOLite> getRelatedMOLites(NetactLab netactLab, String relationship, List<String> mos)
	{
		NasdaWSPersistencyPortType port = initNasdaWS(netactLab);
		GetRelatedMOLitesRequest getRelationshipsRequest = new GetRelatedMOLitesRequest();
		getRelationshipsRequest.setMoId(mos);
		getRelationshipsRequest.setRelationship(relationship);

		GetRelatedMOLitesResponse response = port.getRelatedMOLites(getRelationshipsRequest);	
		try
		{
			if (response.getResult().getBatchItemMOLiteSequenceResult().get(0).getErrorCode().equalsIgnoreCase("OK")) {

				return response.getResult().getBatchItemMOLiteSequenceResult().get(0).getMoLite();
			} else {
				LOGGER.error("GetRelatedMOLitesResponse==="
						+ response.getResult().getBatchItemMOLiteSequenceResult().get(0).getErrorCause());
				return null;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int updateRelationship(NetactLab netactLab, Relationship relationship) {
		int retCode = 0;
		List<String> mos = new ArrayList<String>();
		mos.add(relationship.getSourceMOId());
		List<MOLite> moLites=getRelatedMOLites(netactLab,"MR",mos);

		for(MOLite moLite:moLites)
		{
			// delete
			Relationship delRelationship = new Relationship();
			delRelationship.setRelationshipId("MR");
			delRelationship.setSourceMOId(relationship.getSourceMOId());
			delRelationship.setTargetMOId(moLite.getMoId());
			retCode = deleteRelationship(netactLab, delRelationship);
			if (retCode != 0) {
				return retCode;
			}
		}
		
		//create
		return createRelationship(netactLab,relationship);
		
		
	}
	
	@Override
	public Map<String, String> getNasdaObjectClassMap(String dbIpv4) {
		Map<Object, Map<String, Object>> nasda_OBJECT_CLASSs =  nasdaService.getNasdaObjectClass(dbIpv4);
		Map<String, String> nasdaClassMap = new HashMap<>();
		for ( Map<String, Object> object : nasda_OBJECT_CLASSs.values()) {
			nasdaClassMap.put((String) object.get("OC_NAME").toString(), (String)object.get("OC_ADAPTATION").toString());
		}
		return nasdaClassMap;
	}

	
	private NasdaWSPersistencyPortType initNasdaWS(NetactLab netactLab) {
		String nasdaServiceUrl = "http://%s/netact/oss/nasda/ws-api/NasdaWSPersistencyServiceSOAP?wsdl";
		nasdaServiceUrl = String.format(nasdaServiceUrl, netactLab.getLbwasIpv4());
		NasdaWSPersistencyServiceSOAP nasdaWSPersistencyService = new NasdaWSPersistencyServiceSOAP();
		NasdaWSPersistencyPortType port = nasdaWSPersistencyService.getNasdaWSPersistencyPort();
		((BindingProvider) port).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, nasdaServiceUrl);
		((BindingProvider) port).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "omc");
		((BindingProvider) port).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, netactLab.getOmcPassword());
		return port;
	}

	/**
	 * Init Managed object
	 * @param moId,DN
	 * @param metaClass,
	 * com.nsn.netact.nasda.connectivity:PLMN/DCAP
	 * com.nsn.netact.nasda.common:MR/MRC/SITE
	 * com.nsn.netact.nasda.interfaces:SNMP/NE3SWS/SSH
	 * @param params
	 * version/directIntegration
	 * @return
	 */
	public ManagedObject generateMO(String moId, String metaClass, List<P> params) {
		ManagedObject managedObject = new ManagedObject();
		managedObject.setMoId(moId);
		managedObject.setMetaClass(metaClass);
		managedObject.setMetaVersion("1.0");
		if (params.size() != 0) {
			managedObject.getPOrScalarListOrStructList().addAll(params);
		}
		return managedObject;
	}

	/**
	 *
	 * @param id:MR/AGENT
	 * @param source DN
	 * @param target objectDN/MRDN
	 * @return
	 */
	public Relationship generateRelationship(String id, String source, String target) {
		Relationship relationship = new Relationship();
		relationship.setRelationshipId(id);
		relationship.setSourceMOId(source);
		relationship.setTargetMOId(target);
		return relationship;

	}

	private String getObjectClass(String dn) {
		String[] topoloys = dn.split("/");
		String lastInstance = topoloys[topoloys.length - 1];
		String[] objectTemp = lastInstance.split("-");
		return objectTemp[0].toUpperCase();
	}

	private boolean checkMapKey(Map<String, String> map, String key) {
		if (map.containsKey(key)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int updateMrRelationship(NetactLab netactLab, Relationship relationship, String oldMrDn) {

		if(oldMrDn!=null && oldMrDn.length()>0)
		{
			Relationship delRelationship = new Relationship();
			delRelationship.setRelationshipId("MR");
			delRelationship.setSourceMOId(relationship.getSourceMOId());
			delRelationship.setTargetMOId(oldMrDn);
			int retCode = deleteRelationship(netactLab, delRelationship);
			if (retCode != 0) {
				return retCode;
			}
		}
		//create
		return createRelationship(netactLab,relationship);
	
	}
	
	public int deleteMO(NetactLab netactLab, Relationship relationship, String dn){
		List<String>moIds=new ArrayList<String>();
		moIds.add(dn);
		List<MOLite> mos=getRelatedMOLites(netactLab,"MR", moIds);

		mos=getRelatedMOLites(netactLab,"CHILD", moIds);
		return 0;
	}


}
