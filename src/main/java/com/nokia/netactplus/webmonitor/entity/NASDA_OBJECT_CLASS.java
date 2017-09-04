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
public class NASDA_OBJECT_CLASS implements Serializable {

    private static final long serialVersionUID = 1L;

	private Double OC_ID;
	private String OC_NAME;
	private String OC_ADAPTATION;
	private String OC_ABBREVIATION;
	private String OC_DESCRIPTION;
	private String OC_VENDOR;


	public Double getOC_ID() {
		return OC_ID;
	}

	public void setOC_ID(Double OC_ID) {
		this.OC_ID = OC_ID;
	}

	public String getOC_NAME() {
		return OC_NAME;
	}

	public void setOC_NAME(String OC_NAME) {
		this.OC_NAME = OC_NAME;
	}

	public String getOC_ADAPTATION() {
		return OC_ADAPTATION;
	}

	public void setOC_ADAPTATION(String OC_ADAPTATION) {
		this.OC_ADAPTATION = OC_ADAPTATION;
	}

	public String getOC_ABBREVIATION() {
		return OC_ABBREVIATION;
	}

	public void setOC_ABBREVIATION(String OC_ABBREVIATION) {
		this.OC_ABBREVIATION = OC_ABBREVIATION;
	}

	public String getOC_DESCRIPTION() {
		return OC_DESCRIPTION;
	}

	public void setOC_DESCRIPTION(String OC_DESCRIPTION) {
		this.OC_DESCRIPTION = OC_DESCRIPTION;
	}

	public String getOC_VENDOR() {
		return OC_VENDOR;
	}

	public void setOC_VENDOR(String OC_VENDOR) {
		this.OC_VENDOR = OC_VENDOR;
	}


	@Override
	public String toString(){
		return "NASDA_OBJECT_CLASS [OC_ID=" + OC_ID + ", OC_NAME=" + OC_NAME + ", OC_ADAPTATION=" + OC_ADAPTATION + ", OC_ABBREVIATION=" + OC_ABBREVIATION + ", OC_DESCRIPTION=" + OC_DESCRIPTION + ", OC_VENDOR=" + OC_VENDOR + "]";
	}
}
