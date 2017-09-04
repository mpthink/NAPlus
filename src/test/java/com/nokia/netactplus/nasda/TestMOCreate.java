package com.nokia.netactplus.nasda;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.ws.BindingProvider;

import com.nsn.oss.nasda.access.irp.ws.persistency.NasdaWSPersistencyPortType;
import com.nsn.oss.nasda.access.irp.ws.persistency.NasdaWSPersistencyServiceSOAP;
import com.nsn.oss.nasda.access.irp.ws.persistency.model.ManagedObject;
import com.nsn.oss.nasda.access.irp.ws.persistency.model.P;
import com.nsn.oss.nasda.access.irp.ws.persistency.model.Relationship;
import com.nsn.oss.nasda.access.irp.ws.persistency.operations.CreateMOsRequest;
import com.nsn.oss.nasda.access.irp.ws.persistency.operations.CreateMOsResponse;

public class TestMOCreate {
	public static String convertToXml(Object obj, String encoding) {
		String result = null;
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

			StringWriter writer = new StringWriter();
			marshaller.marshal(obj, writer);
			result = writer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public static <T> T converyToJavaBean(String xml, Class<T> c) {
		T t = null;
		try {
			JAXBContext context = JAXBContext.newInstance(c);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			t = (T) unmarshaller.unmarshal(new StringReader(xml));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return t;
	}

	/**
	 *
	 * @param moId  DN
	 * @param metaClass
	 * com.nsn.netact.nasda.connectivity:PLMN/DCAP
	 * com.nsn.netact.nasda.common:MR/MRC/SITE
	 * com.nsn.netact.nasda.interfaces:SNMP/NE3SWS/SSH
	 * @param params
	 * @return
	 */
	public static ManagedObject createMO(String moId, String metaClass, List<P> params) {
		ManagedObject managedObject = new ManagedObject();
		managedObject.setMoId(moId);
		managedObject.setMetaClass(metaClass);
		managedObject.setMetaVersion("1.0");
		if (params != null) {
			managedObject.getPOrScalarListOrStructList().addAll(params);
		}
		return managedObject;
	}

	public static List<P> commonParams() {
		List<P> params = new ArrayList<>();
		P param1 = new P();
		param1.setName("directIntegration");
		param1.setValue("true");
		P param2 = new P();
		param2.setName("version");
		param2.setValue("base");
		params.add(param1);
		params.add(param2);
		return params;
	}


	/**
	 *
	 * @param id:MR/AGENT
	 * @param source DN
	 * @param target DN
	 * @return
	 */
	public static Relationship createRelationship(String id, String source, String target) {
		Relationship relationship = new Relationship();
		relationship.setRelationshipId(id);
		relationship.setSourceMOId(source);
		relationship.setTargetMOId(target);
		return relationship;

	}

	public static void main(String[] args) {
		String nasdaUrlClab1507 = "http://10.92.67.59/netact/oss/nasda/ws-api/NasdaWSPersistencyServiceSOAP?wsdl";
		NasdaWSPersistencyServiceSOAP nasdaWSPersistencyService = new NasdaWSPersistencyServiceSOAP();
		NasdaWSPersistencyPortType port = nasdaWSPersistencyService.getNasdaWSPersistencyPort();
		((BindingProvider) port).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, nasdaUrlClab1507);
		((BindingProvider) port).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "omc");
		((BindingProvider) port).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "omc");

		List<ManagedObject> mos = new ArrayList<>();
		CreateMOsRequest createMOsRequest = new CreateMOsRequest();

		//mos.add(createMO("PLMN-test/DCAP-XX3", "com.nsn.netact.nasda.connectivity:DCAP", commonParams()));
		mos.add(createMO("PLMN-test/DCAP-XX2/NE3SWS-1", "com.nsn.netact.nasda.interfaces:NE3SWS", null));
		createMOsRequest.setManagedObject(mos);
		CreateMOsResponse response = port.createManagedObjects(createMOsRequest);
		String result = convertToXml(response, "UTF-8");
		System.out.println(result);
		System.err.println(response.getResult().getBatchItemMOLiteResult().get(0).getErrorCode());
		System.err.println(response.getCause());
		/**create relationship
		List<Relationship> relationships = new ArrayList<>();
		RelationshipsRequest relationshipsRequest = new RelationshipsRequest();
		relationships.add(createRelationship("AGENT", "PLMN-test/DCAP-XX2", "PLMN-test/DCAP-XX2"));
		relationshipsRequest.setRelationship(relationships);
		RelationshipsResponse relationshipsResponse = port.createRelationships(relationshipsRequest);
		System.out.println(relationshipsResponse.getErrorCode());
		*/

	}

}
