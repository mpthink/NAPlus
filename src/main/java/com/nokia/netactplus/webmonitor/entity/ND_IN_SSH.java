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
public class ND_IN_SSH implements Serializable {

    private static final long serialVersionUID = 1L;

	private Double OBJ_GID;
	private Double CONF_ID;
	private Date LAST_MODIFIED;
	private String LAST_MODIFIER;
	private String SSH_HOST_NAME;
	private Double SSH_ID;
	private Double SSH_PORT;
	private String SSH_VER;


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

	public String getSSH_HOST_NAME() {
		return SSH_HOST_NAME;
	}

	public void setSSH_HOST_NAME(String SSH_HOST_NAME) {
		this.SSH_HOST_NAME = SSH_HOST_NAME;
	}

	public Double getSSH_ID() {
		return SSH_ID;
	}

	public void setSSH_ID(Double SSH_ID) {
		this.SSH_ID = SSH_ID;
	}

	public Double getSSH_PORT() {
		return SSH_PORT;
	}

	public void setSSH_PORT(Double SSH_PORT) {
		this.SSH_PORT = SSH_PORT;
	}

	public String getSSH_VER() {
		return SSH_VER;
	}

	public void setSSH_VER(String SSH_VER) {
		this.SSH_VER = SSH_VER;
	}


	@Override
	public String toString(){
		return "ND_IN_SSH [OBJ_GID=" + OBJ_GID + ", CONF_ID=" + CONF_ID + ", LAST_MODIFIED=" + LAST_MODIFIED + ", LAST_MODIFIER=" + LAST_MODIFIER + ", SSH_HOST_NAME=" + SSH_HOST_NAME + ", SSH_ID=" + SSH_ID + ", SSH_PORT=" + SSH_PORT + ", SSH_VER=" + SSH_VER + "]";
	}
}
