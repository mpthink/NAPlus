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
public class NASDA_REF_MR implements Serializable {

    private static final long serialVersionUID = 1L;

	private Double MO_GID;
	private Double MR_GID;


	public Double getMO_GID() {
		return MO_GID;
	}

	public void setMO_GID(Double MO_GID) {
		this.MO_GID = MO_GID;
	}

	public Double getMR_GID() {
		return MR_GID;
	}

	public void setMR_GID(Double MR_GID) {
		this.MR_GID = MR_GID;
	}


	@Override
	public String toString(){
		return "NASDA_REF_MR [MO_GID=" + MO_GID + ", MR_GID=" + MR_GID + "]";
	}
}
