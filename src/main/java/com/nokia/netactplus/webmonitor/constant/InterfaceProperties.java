package com.nokia.netactplus.webmonitor.constant;

import java.util.HashMap;
import java.util.Map;

public class InterfaceProperties {

	public final static Map<String, String> SNMPProperties = new HashMap<>();
	public final static Map<String, String> SSHProperties = new HashMap<>();
	public final static Map<String, String> FTPProperties = new HashMap<>();
	public final static Map<String, String> NE3SWSProperties = new HashMap<>();
	public final static Map<String, String> HTTPProperties = new HashMap<>();
	public final static Map<String, String>  PropertiesObject = new HashMap<>();


	static {
		SNMPProperties.put("hostName", "");
		SNMPProperties.put("additionalHostNames", "");
		SNMPProperties.put("neSurveillanceSupervisionMethod", "");
		SNMPProperties.put("port", "");
		SNMPProperties.put("snmpVersion", "");

		SSHProperties.put("hostName", "");
		SSHProperties.put("port", "");

		FTPProperties.put("hostName", "");
		FTPProperties.put("port", "");
		FTPProperties.put("securityMode", "");

		NE3SWSProperties.put("baseServiceName", "NE3S/1.0");
		NE3SWSProperties.put("hostName", "");
		NE3SWSProperties.put("httpPort", "");
		NE3SWSProperties.put("httpsPort", "");
		NE3SWSProperties.put("ipVersion", "");
		NE3SWSProperties.put("ne3sBasicOperationsService", "NE3SBasicOperationsService");
		NE3SWSProperties.put("ne3sBulkOperationsService", "NE3SBulkOperationsService");
		NE3SWSProperties.put("ne3sOperationService", "NE3SOperationService");
		NE3SWSProperties.put("ne3sRegistrationService", "NE3SRegistrationService");
		NE3SWSProperties.put("ne3sSessionService", "NE3SSessionService");
		NE3SWSProperties.put("securityMode", "0");

		HTTPProperties.put("port", "");
		HTTPProperties.put("hostName", "");
		HTTPProperties.put("securityMode", "");
	
		PropertiesObject.put("NE3SWS", "ND_IN_NE_3_SWS");
	}
}
