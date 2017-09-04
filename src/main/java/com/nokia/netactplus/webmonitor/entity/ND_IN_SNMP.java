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
public class ND_IN_SNMP implements Serializable {

    private static final long serialVersionUID = 1L;

	private Double OBJ_GID;
	private Double CONF_ID;
	private Date LAST_MODIFIED;
	private String LAST_MODIFIER;
	private Double SNMP_4R1521NSMFMI;
	private String SNMP_ADLHN_1;
	private String SNMP_HOST_NAME;
	private Double SNMP_ID;
	private Double SNMP_NSFTIP_3;
	private Double SNMP_NSSI_6;
	private Double SNMP_NSSIPTBS_4;
	private Double SNMP_NSSM_7;
	private Double SNMP_NSSTIP_5;
	private Double SNMP_PORT;
	private Double SNMP_SNMP_VER;
	private String SNMP_VER;


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

	public Double getSNMP_4R1521NSMFMI() {
		return SNMP_4R1521NSMFMI;
	}

	public void setSNMP_4R1521NSMFMI(Double SNMP_4R1521NSMFMI) {
		this.SNMP_4R1521NSMFMI = SNMP_4R1521NSMFMI;
	}

	public String getSNMP_ADLHN_1() {
		return SNMP_ADLHN_1;
	}

	public void setSNMP_ADLHN_1(String SNMP_ADLHN_1) {
		this.SNMP_ADLHN_1 = SNMP_ADLHN_1;
	}

	public String getSNMP_HOST_NAME() {
		return SNMP_HOST_NAME;
	}

	public void setSNMP_HOST_NAME(String SNMP_HOST_NAME) {
		this.SNMP_HOST_NAME = SNMP_HOST_NAME;
	}

	public Double getSNMP_ID() {
		return SNMP_ID;
	}

	public void setSNMP_ID(Double SNMP_ID) {
		this.SNMP_ID = SNMP_ID;
	}

	public Double getSNMP_NSFTIP_3() {
		return SNMP_NSFTIP_3;
	}

	public void setSNMP_NSFTIP_3(Double SNMP_NSFTIP_3) {
		this.SNMP_NSFTIP_3 = SNMP_NSFTIP_3;
	}

	public Double getSNMP_NSSI_6() {
		return SNMP_NSSI_6;
	}

	public void setSNMP_NSSI_6(Double SNMP_NSSI_6) {
		this.SNMP_NSSI_6 = SNMP_NSSI_6;
	}

	public Double getSNMP_NSSIPTBS_4() {
		return SNMP_NSSIPTBS_4;
	}

	public void setSNMP_NSSIPTBS_4(Double SNMP_NSSIPTBS_4) {
		this.SNMP_NSSIPTBS_4 = SNMP_NSSIPTBS_4;
	}

	public Double getSNMP_NSSM_7() {
		return SNMP_NSSM_7;
	}

	public void setSNMP_NSSM_7(Double SNMP_NSSM_7) {
		this.SNMP_NSSM_7 = SNMP_NSSM_7;
	}

	public Double getSNMP_NSSTIP_5() {
		return SNMP_NSSTIP_5;
	}

	public void setSNMP_NSSTIP_5(Double SNMP_NSSTIP_5) {
		this.SNMP_NSSTIP_5 = SNMP_NSSTIP_5;
	}

	public Double getSNMP_PORT() {
		return SNMP_PORT;
	}

	public void setSNMP_PORT(Double SNMP_PORT) {
		this.SNMP_PORT = SNMP_PORT;
	}

	public Double getSNMP_SNMP_VER() {
		return SNMP_SNMP_VER;
	}

	public void setSNMP_SNMP_VER(Double SNMP_SNMP_VER) {
		this.SNMP_SNMP_VER = SNMP_SNMP_VER;
	}

	public String getSNMP_VER() {
		return SNMP_VER;
	}

	public void setSNMP_VER(String SNMP_VER) {
		this.SNMP_VER = SNMP_VER;
	}


	@Override
	public String toString(){
		return "ND_IN_SNMP [OBJ_GID=" + OBJ_GID + ", CONF_ID=" + CONF_ID + ", LAST_MODIFIED=" + LAST_MODIFIED + ", LAST_MODIFIER=" + LAST_MODIFIER + ", SNMP_4R1521NSMFMI=" + SNMP_4R1521NSMFMI + ", SNMP_ADLHN_1=" + SNMP_ADLHN_1 + ", SNMP_HOST_NAME=" + SNMP_HOST_NAME + ", SNMP_ID=" + SNMP_ID + ", SNMP_NSFTIP_3=" + SNMP_NSFTIP_3 + ", SNMP_NSSI_6=" + SNMP_NSSI_6 + ", SNMP_NSSIPTBS_4=" + SNMP_NSSIPTBS_4 + ", SNMP_NSSM_7=" + SNMP_NSSM_7 + ", SNMP_NSSTIP_5=" + SNMP_NSSTIP_5 + ", SNMP_PORT=" + SNMP_PORT + ", SNMP_SNMP_VER=" + SNMP_SNMP_VER + ", SNMP_VER=" + SNMP_VER + "]";
	}
}
