package com.nokia.netactplus.webmonitor.entity;

import java.io.Serializable;


/**
 * <p>
 * ${table.comment}
 * </p>
 *
 * @author mpthink
 * @since 2017-03-31
 */
public class FM_BASIC_ADAPTATION implements Serializable {

    private static final long serialVersionUID = 1L;

	private Double BA_ID;
	private String BA_PATCH_LEVEL;
	private String BA_ADAP_ID;
	private String BA_ADAP_RELEASE;
	private String BA_FRAGMENT_ID;


	public Double getBA_ID() {
		return BA_ID;
	}

	public void setBA_ID(Double BA_ID) {
		this.BA_ID = BA_ID;
	}

	public String getBA_PATCH_LEVEL() {
		return BA_PATCH_LEVEL;
	}

	public void setBA_PATCH_LEVEL(String BA_PATCH_LEVEL) {
		this.BA_PATCH_LEVEL = BA_PATCH_LEVEL;
	}

	public String getBA_ADAP_ID() {
		return BA_ADAP_ID;
	}

	public void setBA_ADAP_ID(String BA_ADAP_ID) {
		this.BA_ADAP_ID = BA_ADAP_ID;
	}

	public String getBA_ADAP_RELEASE() {
		return BA_ADAP_RELEASE;
	}

	public void setBA_ADAP_RELEASE(String BA_ADAP_RELEASE) {
		this.BA_ADAP_RELEASE = BA_ADAP_RELEASE;
	}

	public String getBA_FRAGMENT_ID() {
		return BA_FRAGMENT_ID;
	}

	public void setBA_FRAGMENT_ID(String BA_FRAGMENT_ID) {
		this.BA_FRAGMENT_ID = BA_FRAGMENT_ID;
	}


	@Override
	public String toString(){
		return "FM_BASIC_ADAPTATION [BA_ID=" + BA_ID + ", BA_PATCH_LEVEL=" + BA_PATCH_LEVEL + ", BA_ADAP_ID=" + BA_ADAP_ID + ", BA_ADAP_RELEASE=" + BA_ADAP_RELEASE + ", BA_FRAGMENT_ID=" + BA_FRAGMENT_ID + "]";
	}
}
