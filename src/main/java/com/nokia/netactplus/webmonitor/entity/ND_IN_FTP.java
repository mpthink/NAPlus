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
public class ND_IN_FTP implements Serializable {

    private static final long serialVersionUID = 1L;

	private Double OBJ_GID;
	private Double CONF_ID;
	private Date LAST_MODIFIED;
	private String LAST_MODIFIER;
	private Double FTP_FTP_TIMEOUT;
	private String FTP_GRC_N_EFTP_PATH;
	private String FTP_HOST_NAME;
	private String FTP_ID;
	private Double FTP_PORT;
	private Double FTP_SECURITY_MODE;
	private String FTP_VER;


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

	public Double getFTP_FTP_TIMEOUT() {
		return FTP_FTP_TIMEOUT;
	}

	public void setFTP_FTP_TIMEOUT(Double FTP_FTP_TIMEOUT) {
		this.FTP_FTP_TIMEOUT = FTP_FTP_TIMEOUT;
	}

	public String getFTP_GRC_N_EFTP_PATH() {
		return FTP_GRC_N_EFTP_PATH;
	}

	public void setFTP_GRC_N_EFTP_PATH(String FTP_GRC_N_EFTP_PATH) {
		this.FTP_GRC_N_EFTP_PATH = FTP_GRC_N_EFTP_PATH;
	}

	public String getFTP_HOST_NAME() {
		return FTP_HOST_NAME;
	}

	public void setFTP_HOST_NAME(String FTP_HOST_NAME) {
		this.FTP_HOST_NAME = FTP_HOST_NAME;
	}

	public String getFTP_ID() {
		return FTP_ID;
	}

	public void setFTP_ID(String FTP_ID) {
		this.FTP_ID = FTP_ID;
	}

	public Double getFTP_PORT() {
		return FTP_PORT;
	}

	public void setFTP_PORT(Double FTP_PORT) {
		this.FTP_PORT = FTP_PORT;
	}

	public Double getFTP_SECURITY_MODE() {
		return FTP_SECURITY_MODE;
	}

	public void setFTP_SECURITY_MODE(Double FTP_SECURITY_MODE) {
		this.FTP_SECURITY_MODE = FTP_SECURITY_MODE;
	}

	public String getFTP_VER() {
		return FTP_VER;
	}

	public void setFTP_VER(String FTP_VER) {
		this.FTP_VER = FTP_VER;
	}


	@Override
	public String toString(){
		return "ND_IN_FTP [OBJ_GID=" + OBJ_GID + ", CONF_ID=" + CONF_ID + ", LAST_MODIFIED=" + LAST_MODIFIED + ", LAST_MODIFIER=" + LAST_MODIFIER + ", FTP_FTP_TIMEOUT=" + FTP_FTP_TIMEOUT + ", FTP_GRC_N_EFTP_PATH=" + FTP_GRC_N_EFTP_PATH + ", FTP_HOST_NAME=" + FTP_HOST_NAME + ", FTP_ID=" + FTP_ID + ", FTP_PORT=" + FTP_PORT + ", FTP_SECURITY_MODE=" + FTP_SECURITY_MODE + ", FTP_VER=" + FTP_VER + "]";
	}
}
