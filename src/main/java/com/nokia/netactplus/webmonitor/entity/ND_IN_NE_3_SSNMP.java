package com.nokia.netactplus.webmonitor.entity;

import java.util.Date;
import java.io.Serializable;


/**
 * <p>
 * ${table.comment}
 * </p>
 *
 * @author mpthink
 * @since 2017-03-31
 */
public class ND_IN_NE_3_SSNMP implements Serializable {

    private static final long serialVersionUID = 1L;

	private Double OBJ_GID;
	private Double CONF_ID;
	private Date LAST_MODIFIED;
	private String LAST_MODIFIER;
	private String NE3SSNMP_GETSET_HOSTNAME;
	private Double NE3SSNMP_ID;
	private String NE3SSNMP_PIA_3;
	private Double NE3SSNMP_PORT;
	private String NE3SSNMP_SEC_IP_ADDRESS;
	private Double NE3SSNMP_SNMP_VER;
	private String NE3SSNMP_VER;


	public Double getOBJ_GID() {
		return OBJ_GID;
	}

	public void setOBJ_GID(Double OBJ_GID) {
		this.OBJ_GID = OBJ_GID;
	}

	public Double getCONF_ID() {
		return CONF_ID;
	}

	public void setCONF_ID(Double CONF_ID) {
		this.CONF_ID = CONF_ID;
	}

	public Date getLAST_MODIFIED() {
		return LAST_MODIFIED;
	}

	public void setLAST_MODIFIED(Date LAST_MODIFIED) {
		this.LAST_MODIFIED = LAST_MODIFIED;
	}

	public String getLAST_MODIFIER() {
		return LAST_MODIFIER;
	}

	public void setLAST_MODIFIER(String LAST_MODIFIER) {
		this.LAST_MODIFIER = LAST_MODIFIER;
	}

	public String getNE3SSNMP_GETSET_HOSTNAME() {
		return NE3SSNMP_GETSET_HOSTNAME;
	}

	public void setNE3SSNMP_GETSET_HOSTNAME(String NE3SSNMP_GETSET_HOSTNAME) {
		this.NE3SSNMP_GETSET_HOSTNAME = NE3SSNMP_GETSET_HOSTNAME;
	}

	public Double getNE3SSNMP_ID() {
		return NE3SSNMP_ID;
	}

	public void setNE3SSNMP_ID(Double NE3SSNMP_ID) {
		this.NE3SSNMP_ID = NE3SSNMP_ID;
	}

	public String getNE3SSNMP_PIA_3() {
		return NE3SSNMP_PIA_3;
	}

	public void setNE3SSNMP_PIA_3(String NE3SSNMP_PIA_3) {
		this.NE3SSNMP_PIA_3 = NE3SSNMP_PIA_3;
	}

	public Double getNE3SSNMP_PORT() {
		return NE3SSNMP_PORT;
	}

	public void setNE3SSNMP_PORT(Double NE3SSNMP_PORT) {
		this.NE3SSNMP_PORT = NE3SSNMP_PORT;
	}

	public String getNE3SSNMP_SEC_IP_ADDRESS() {
		return NE3SSNMP_SEC_IP_ADDRESS;
	}

	public void setNE3SSNMP_SEC_IP_ADDRESS(String NE3SSNMP_SEC_IP_ADDRESS) {
		this.NE3SSNMP_SEC_IP_ADDRESS = NE3SSNMP_SEC_IP_ADDRESS;
	}

	public Double getNE3SSNMP_SNMP_VER() {
		return NE3SSNMP_SNMP_VER;
	}

	public void setNE3SSNMP_SNMP_VER(Double NE3SSNMP_SNMP_VER) {
		this.NE3SSNMP_SNMP_VER = NE3SSNMP_SNMP_VER;
	}

	public String getNE3SSNMP_VER() {
		return NE3SSNMP_VER;
	}

	public void setNE3SSNMP_VER(String NE3SSNMP_VER) {
		this.NE3SSNMP_VER = NE3SSNMP_VER;
	}


	@Override
	public String toString(){
		return "ND_IN_NE_3_SSNMP [OBJ_GID=" + OBJ_GID + ", CONF_ID=" + CONF_ID + ", LAST_MODIFIED=" + LAST_MODIFIED + ", LAST_MODIFIER=" + LAST_MODIFIER + ", NE3SSNMP_GETSET_HOSTNAME=" + NE3SSNMP_GETSET_HOSTNAME + ", NE3SSNMP_ID=" + NE3SSNMP_ID + ", NE3SSNMP_PIA_3=" + NE3SSNMP_PIA_3 + ", NE3SSNMP_PORT=" + NE3SSNMP_PORT + ", NE3SSNMP_SEC_IP_ADDRESS=" + NE3SSNMP_SEC_IP_ADDRESS + ", NE3SSNMP_SNMP_VER=" + NE3SSNMP_SNMP_VER + ", NE3SSNMP_VER=" + NE3SSNMP_VER + "]";
	}
}
