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
public class NASDA_OBJECTS implements Serializable {

    private static final long serialVersionUID = 1L;

	private Double CO_GID;
	private Double CO_OC_ID;
	private String CO_SYS_VERSION;
	private Double CO_DI_TOKEN;
	private Date CO_TIME_STAMP;
	private String CO_OBJECT_INSTANCE;
	private Double CO_PARENT_GID;
	private String CO_DN;
	private String CO_NAME;


	public Double getCO_GID() {
		return CO_GID;
	}

	public void setCO_GID(Double CO_GID) {
		this.CO_GID = CO_GID;
	}

	public Double getCO_OC_ID() {
		return CO_OC_ID;
	}

	public void setCO_OC_ID(Double CO_OC_ID) {
		this.CO_OC_ID = CO_OC_ID;
	}

	public String getCO_SYS_VERSION() {
		return CO_SYS_VERSION;
	}

	public void setCO_SYS_VERSION(String CO_SYS_VERSION) {
		this.CO_SYS_VERSION = CO_SYS_VERSION;
	}

	public Double getCO_DI_TOKEN() {
		return CO_DI_TOKEN;
	}

	public void setCO_DI_TOKEN(Double CO_DI_TOKEN) {
		this.CO_DI_TOKEN = CO_DI_TOKEN;
	}

	public Date getCO_TIME_STAMP() {
		return CO_TIME_STAMP;
	}

	public void setCO_TIME_STAMP(Date CO_TIME_STAMP) {
		this.CO_TIME_STAMP = CO_TIME_STAMP;
	}

	public String getCO_OBJECT_INSTANCE() {
		return CO_OBJECT_INSTANCE;
	}

	public void setCO_OBJECT_INSTANCE(String CO_OBJECT_INSTANCE) {
		this.CO_OBJECT_INSTANCE = CO_OBJECT_INSTANCE;
	}

	public Double getCO_PARENT_GID() {
		return CO_PARENT_GID;
	}

	public void setCO_PARENT_GID(Double CO_PARENT_GID) {
		this.CO_PARENT_GID = CO_PARENT_GID;
	}

	public String getCO_DN() {
		return CO_DN;
	}

	public void setCO_DN(String CO_DN) {
		this.CO_DN = CO_DN;
	}

	public String getCO_NAME() {
		return CO_NAME;
	}

	public void setCO_NAME(String CO_NAME) {
		this.CO_NAME = CO_NAME;
	}


	@Override
	public String toString(){
		return "NASDA_OBJECTS [CO_GID=" + CO_GID + ", CO_OC_ID=" + CO_OC_ID + ", CO_SYS_VERSION=" + CO_SYS_VERSION + ", CO_DI_TOKEN=" + CO_DI_TOKEN + ", CO_TIME_STAMP=" + CO_TIME_STAMP + ", CO_OBJECT_INSTANCE=" + CO_OBJECT_INSTANCE + ", CO_PARENT_GID=" + CO_PARENT_GID + ", CO_DN=" + CO_DN + ", CO_NAME=" + CO_NAME + "]";
	}
}
