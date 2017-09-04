package com.nokia.netactplus.webmonitor.entity;

import java.util.Date;
import java.io.Serializable;


/**
 * <p>
 * ${table.comment}
 * </p>
 *
 * @author mpthink
 * @since 2017-03-10
 */
public class ND_IN_HTTP implements Serializable {

    private static final long serialVersionUID = 1L;

	private String HTTP_VER;
	private Double HTTP_SECURITY_MODE;
	private Double HTTP_PORT;
	private Double HTTP_ID;
	private String HTTP_HOST_NAME;
	private String LAST_MODIFIER;
	private Date LAST_MODIFIED;
	private Double CONF_ID;
	private Double OBJ_GID;


	public String getHTTP_VER() {
		return HTTP_VER;
	}

	public void setHTTP_VER(String HTTP_VER) {
		this.HTTP_VER = HTTP_VER;
	}

	public Double getHTTP_SECURITY_MODE() {
		return HTTP_SECURITY_MODE;
	}

	public void setHTTP_SECURITY_MODE(Double HTTP_SECURITY_MODE) {
		this.HTTP_SECURITY_MODE = HTTP_SECURITY_MODE;
	}

	public Double getHTTP_PORT() {
		return HTTP_PORT;
	}

	public void setHTTP_PORT(Double HTTP_PORT) {
		this.HTTP_PORT = HTTP_PORT;
	}

	public Double getHTTP_ID() {
		return HTTP_ID;
	}

	public void setHTTP_ID(Double HTTP_ID) {
		this.HTTP_ID = HTTP_ID;
	}

	public String getHTTP_HOST_NAME() {
		return HTTP_HOST_NAME;
	}

	public void setHTTP_HOST_NAME(String HTTP_HOST_NAME) {
		this.HTTP_HOST_NAME = HTTP_HOST_NAME;
	}

	public String getLAST_MODIFIER() {
		return LAST_MODIFIER;
	}

	public void setLAST_MODIFIER(String LAST_MODIFIER) {
		this.LAST_MODIFIER = LAST_MODIFIER;
	}

	public Date getLAST_MODIFIED() {
		return LAST_MODIFIED;
	}

	public void setLAST_MODIFIED(Date LAST_MODIFIED) {
		this.LAST_MODIFIED = LAST_MODIFIED;
	}

	public Double getCONF_ID() {
		return CONF_ID;
	}

	public void setCONF_ID(Double CONF_ID) {
		this.CONF_ID = CONF_ID;
	}

	public Double getOBJ_GID() {
		return OBJ_GID;
	}

	public void setOBJ_GID(Double OBJ_GID) {
		this.OBJ_GID = OBJ_GID;
	}


	@Override
	public String toString(){
		return "ND_IN_HTTP [HTTP_VER=" + HTTP_VER + ", HTTP_SECURITY_MODE=" + HTTP_SECURITY_MODE + ", HTTP_PORT=" + HTTP_PORT + ", HTTP_ID=" + HTTP_ID + ", HTTP_HOST_NAME=" + HTTP_HOST_NAME + ", LAST_MODIFIER=" + LAST_MODIFIER + ", LAST_MODIFIED=" + LAST_MODIFIED + ", CONF_ID=" + CONF_ID + ", OBJ_GID=" + OBJ_GID + "]";
	}
}
