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
public class NASDA_REF_AGENT implements Serializable {

    private static final long serialVersionUID = 1L;

	private Double MO_GID;
	private Double AGENT_GID;


	public Double getMO_GID() {
		return MO_GID;
	}

	public void setMO_GID(Double MO_GID) {
		this.MO_GID = MO_GID;
	}

	public Double getAGENT_GID() {
		return AGENT_GID;
	}

	public void setAGENT_GID(Double AGENT_GID) {
		this.AGENT_GID = AGENT_GID;
	}


	@Override
	public String toString(){
		return "NASDA_REF_AGENT [MO_GID=" + MO_GID + ", AGENT_GID=" + AGENT_GID + "]";
	}
}
