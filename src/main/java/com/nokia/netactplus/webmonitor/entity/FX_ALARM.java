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
public class FX_ALARM implements Serializable {

    private static final long serialVersionUID = 1L;

	private Double CONSEC_NBR;
	private String DN;
	private Double ALARM_TYPE;
	private Double ALARM_STATUS;
	private Double ORIGINAL_SEVERITY;
	private Date ALARM_TIME;
	private Date CANCEL_TIME;
	private String CANCELLED_BY;
	private Double ACK_STATUS;
	private Date ACK_TIME;
	private String ACKED_BY;
	private Double ALARM_NUMBER;
	private Double SEVERITY;
	private String NOTIFICATION_ID;
	private Double FILTERED_FROM;
	private String TEXT;
	private Date EVENT_TIME;
	private Date INSERT_TIME;
	private String TROUBLE_TICKET_ID;
	private Double INTERNAL_ALARM;
	private String EXTRA_TEXT;
	private String USER_ADDITIONAL_INFO;
	private String SUPPLEMENTARY_INFO;
	private String DIAGNOSTIC_INFO;
	private String ADDITIONAL_TEXT5;
	private String ADDITIONAL_TEXT6;
	private String ADDITIONAL_TEXT7;
	private Double PROBABLE_CAUSE;
	private Double NE_GID;
	private Double NE_CONT_GID;
	private Double CORRELATED_ALARM;
	private Double CORRELATING_ALARM;
	private Date UPDATE_TIMESTAMP;
	private Double CORRELATOR_CREATED;
	private Double PIPE_KEY;
	private Double DELETED_BY;
	private Double NOTES_INDICATOR;
	private String ORIGINAL_DN;
	private String LIFTED_DN;
	private Double ALARM_UPLOAD_SYNC;
	private String ADAPTATION_ID;
	private String ADAPTATION_RELEASE;
	private String OC_ID;
	private Double AGENT_ID_TYPE;
	private String AGENT_ID;
	private Double ALARM_COUNT;
	private Date TERMINATED_TIME;


	public Double getCONSEC_NBR() {
		return CONSEC_NBR;
	}

	public void setCONSEC_NBR(Double CONSEC_NBR) {
		this.CONSEC_NBR = CONSEC_NBR;
	}

	public String getDN() {
		return DN;
	}

	public void setDN(String DN) {
		this.DN = DN;
	}

	public Double getALARM_TYPE() {
		return ALARM_TYPE;
	}

	public void setALARM_TYPE(Double ALARM_TYPE) {
		this.ALARM_TYPE = ALARM_TYPE;
	}

	public Double getALARM_STATUS() {
		return ALARM_STATUS;
	}

	public void setALARM_STATUS(Double ALARM_STATUS) {
		this.ALARM_STATUS = ALARM_STATUS;
	}

	public Double getORIGINAL_SEVERITY() {
		return ORIGINAL_SEVERITY;
	}

	public void setORIGINAL_SEVERITY(Double ORIGINAL_SEVERITY) {
		this.ORIGINAL_SEVERITY = ORIGINAL_SEVERITY;
	}

	public Date getALARM_TIME() {
		return ALARM_TIME;
	}

	public void setALARM_TIME(Date ALARM_TIME) {
		this.ALARM_TIME = ALARM_TIME;
	}

	public Date getCANCEL_TIME() {
		return CANCEL_TIME;
	}

	public void setCANCEL_TIME(Date CANCEL_TIME) {
		this.CANCEL_TIME = CANCEL_TIME;
	}

	public String getCANCELLED_BY() {
		return CANCELLED_BY;
	}

	public void setCANCELLED_BY(String CANCELLED_BY) {
		this.CANCELLED_BY = CANCELLED_BY;
	}

	public Double getACK_STATUS() {
		return ACK_STATUS;
	}

	public void setACK_STATUS(Double ACK_STATUS) {
		this.ACK_STATUS = ACK_STATUS;
	}

	public Date getACK_TIME() {
		return ACK_TIME;
	}

	public void setACK_TIME(Date ACK_TIME) {
		this.ACK_TIME = ACK_TIME;
	}

	public String getACKED_BY() {
		return ACKED_BY;
	}

	public void setACKED_BY(String ACKED_BY) {
		this.ACKED_BY = ACKED_BY;
	}

	public Double getALARM_NUMBER() {
		return ALARM_NUMBER;
	}

	public void setALARM_NUMBER(Double ALARM_NUMBER) {
		this.ALARM_NUMBER = ALARM_NUMBER;
	}

	public Double getSEVERITY() {
		return SEVERITY;
	}

	public void setSEVERITY(Double SEVERITY) {
		this.SEVERITY = SEVERITY;
	}

	public String getNOTIFICATION_ID() {
		return NOTIFICATION_ID;
	}

	public void setNOTIFICATION_ID(String NOTIFICATION_ID) {
		this.NOTIFICATION_ID = NOTIFICATION_ID;
	}

	public Double getFILTERED_FROM() {
		return FILTERED_FROM;
	}

	public void setFILTERED_FROM(Double FILTERED_FROM) {
		this.FILTERED_FROM = FILTERED_FROM;
	}

	public String getTEXT() {
		return TEXT;
	}

	public void setTEXT(String TEXT) {
		this.TEXT = TEXT;
	}

	public Date getEVENT_TIME() {
		return EVENT_TIME;
	}

	public void setEVENT_TIME(Date EVENT_TIME) {
		this.EVENT_TIME = EVENT_TIME;
	}

	public Date getINSERT_TIME() {
		return INSERT_TIME;
	}

	public void setINSERT_TIME(Date INSERT_TIME) {
		this.INSERT_TIME = INSERT_TIME;
	}

	public String getTROUBLE_TICKET_ID() {
		return TROUBLE_TICKET_ID;
	}

	public void setTROUBLE_TICKET_ID(String TROUBLE_TICKET_ID) {
		this.TROUBLE_TICKET_ID = TROUBLE_TICKET_ID;
	}

	public Double getINTERNAL_ALARM() {
		return INTERNAL_ALARM;
	}

	public void setINTERNAL_ALARM(Double INTERNAL_ALARM) {
		this.INTERNAL_ALARM = INTERNAL_ALARM;
	}

	public String getEXTRA_TEXT() {
		return EXTRA_TEXT;
	}

	public void setEXTRA_TEXT(String EXTRA_TEXT) {
		this.EXTRA_TEXT = EXTRA_TEXT;
	}

	public String getUSER_ADDITIONAL_INFO() {
		return USER_ADDITIONAL_INFO;
	}

	public void setUSER_ADDITIONAL_INFO(String USER_ADDITIONAL_INFO) {
		this.USER_ADDITIONAL_INFO = USER_ADDITIONAL_INFO;
	}

	public String getSUPPLEMENTARY_INFO() {
		return SUPPLEMENTARY_INFO;
	}

	public void setSUPPLEMENTARY_INFO(String SUPPLEMENTARY_INFO) {
		this.SUPPLEMENTARY_INFO = SUPPLEMENTARY_INFO;
	}

	public String getDIAGNOSTIC_INFO() {
		return DIAGNOSTIC_INFO;
	}

	public void setDIAGNOSTIC_INFO(String DIAGNOSTIC_INFO) {
		this.DIAGNOSTIC_INFO = DIAGNOSTIC_INFO;
	}

	public String getADDITIONAL_TEXT5() {
		return ADDITIONAL_TEXT5;
	}

	public void setADDITIONAL_TEXT5(String ADDITIONAL_TEXT5) {
		this.ADDITIONAL_TEXT5 = ADDITIONAL_TEXT5;
	}

	public String getADDITIONAL_TEXT6() {
		return ADDITIONAL_TEXT6;
	}

	public void setADDITIONAL_TEXT6(String ADDITIONAL_TEXT6) {
		this.ADDITIONAL_TEXT6 = ADDITIONAL_TEXT6;
	}

	public String getADDITIONAL_TEXT7() {
		return ADDITIONAL_TEXT7;
	}

	public void setADDITIONAL_TEXT7(String ADDITIONAL_TEXT7) {
		this.ADDITIONAL_TEXT7 = ADDITIONAL_TEXT7;
	}

	public Double getPROBABLE_CAUSE() {
		return PROBABLE_CAUSE;
	}

	public void setPROBABLE_CAUSE(Double PROBABLE_CAUSE) {
		this.PROBABLE_CAUSE = PROBABLE_CAUSE;
	}

	public Double getNE_GID() {
		return NE_GID;
	}

	public void setNE_GID(Double NE_GID) {
		this.NE_GID = NE_GID;
	}

	public Double getNE_CONT_GID() {
		return NE_CONT_GID;
	}

	public void setNE_CONT_GID(Double NE_CONT_GID) {
		this.NE_CONT_GID = NE_CONT_GID;
	}

	public Double getCORRELATED_ALARM() {
		return CORRELATED_ALARM;
	}

	public void setCORRELATED_ALARM(Double CORRELATED_ALARM) {
		this.CORRELATED_ALARM = CORRELATED_ALARM;
	}

	public Double getCORRELATING_ALARM() {
		return CORRELATING_ALARM;
	}

	public void setCORRELATING_ALARM(Double CORRELATING_ALARM) {
		this.CORRELATING_ALARM = CORRELATING_ALARM;
	}

	public Date getUPDATE_TIMESTAMP() {
		return UPDATE_TIMESTAMP;
	}

	public void setUPDATE_TIMESTAMP(Date UPDATE_TIMESTAMP) {
		this.UPDATE_TIMESTAMP = UPDATE_TIMESTAMP;
	}

	public Double getCORRELATOR_CREATED() {
		return CORRELATOR_CREATED;
	}

	public void setCORRELATOR_CREATED(Double CORRELATOR_CREATED) {
		this.CORRELATOR_CREATED = CORRELATOR_CREATED;
	}

	public Double getPIPE_KEY() {
		return PIPE_KEY;
	}

	public void setPIPE_KEY(Double PIPE_KEY) {
		this.PIPE_KEY = PIPE_KEY;
	}

	public Double getDELETED_BY() {
		return DELETED_BY;
	}

	public void setDELETED_BY(Double DELETED_BY) {
		this.DELETED_BY = DELETED_BY;
	}

	public Double getNOTES_INDICATOR() {
		return NOTES_INDICATOR;
	}

	public void setNOTES_INDICATOR(Double NOTES_INDICATOR) {
		this.NOTES_INDICATOR = NOTES_INDICATOR;
	}

	public String getORIGINAL_DN() {
		return ORIGINAL_DN;
	}

	public void setORIGINAL_DN(String ORIGINAL_DN) {
		this.ORIGINAL_DN = ORIGINAL_DN;
	}

	public String getLIFTED_DN() {
		return LIFTED_DN;
	}

	public void setLIFTED_DN(String LIFTED_DN) {
		this.LIFTED_DN = LIFTED_DN;
	}

	public Double getALARM_UPLOAD_SYNC() {
		return ALARM_UPLOAD_SYNC;
	}

	public void setALARM_UPLOAD_SYNC(Double ALARM_UPLOAD_SYNC) {
		this.ALARM_UPLOAD_SYNC = ALARM_UPLOAD_SYNC;
	}

	public String getADAPTATION_ID() {
		return ADAPTATION_ID;
	}

	public void setADAPTATION_ID(String ADAPTATION_ID) {
		this.ADAPTATION_ID = ADAPTATION_ID;
	}

	public String getADAPTATION_RELEASE() {
		return ADAPTATION_RELEASE;
	}

	public void setADAPTATION_RELEASE(String ADAPTATION_RELEASE) {
		this.ADAPTATION_RELEASE = ADAPTATION_RELEASE;
	}

	public String getOC_ID() {
		return OC_ID;
	}

	public void setOC_ID(String OC_ID) {
		this.OC_ID = OC_ID;
	}

	public Double getAGENT_ID_TYPE() {
		return AGENT_ID_TYPE;
	}

	public void setAGENT_ID_TYPE(Double AGENT_ID_TYPE) {
		this.AGENT_ID_TYPE = AGENT_ID_TYPE;
	}

	public String getAGENT_ID() {
		return AGENT_ID;
	}

	public void setAGENT_ID(String AGENT_ID) {
		this.AGENT_ID = AGENT_ID;
	}

	public Double getALARM_COUNT() {
		return ALARM_COUNT;
	}

	public void setALARM_COUNT(Double ALARM_COUNT) {
		this.ALARM_COUNT = ALARM_COUNT;
	}

	public Date getTERMINATED_TIME() {
		return TERMINATED_TIME;
	}

	public void setTERMINATED_TIME(Date TERMINATED_TIME) {
		this.TERMINATED_TIME = TERMINATED_TIME;
	}


	@Override
	public String toString(){
		return "FX_ALARM [CONSEC_NBR=" + CONSEC_NBR + ", DN=" + DN + ", ALARM_TYPE=" + ALARM_TYPE + ", ALARM_STATUS=" + ALARM_STATUS + ", ORIGINAL_SEVERITY=" + ORIGINAL_SEVERITY + ", ALARM_TIME=" + ALARM_TIME + ", CANCEL_TIME=" + CANCEL_TIME + ", CANCELLED_BY=" + CANCELLED_BY + ", ACK_STATUS=" + ACK_STATUS + ", ACK_TIME=" + ACK_TIME + ", ACKED_BY=" + ACKED_BY + ", ALARM_NUMBER=" + ALARM_NUMBER + ", SEVERITY=" + SEVERITY + ", NOTIFICATION_ID=" + NOTIFICATION_ID + ", FILTERED_FROM=" + FILTERED_FROM + ", TEXT=" + TEXT + ", EVENT_TIME=" + EVENT_TIME + ", INSERT_TIME=" + INSERT_TIME + ", TROUBLE_TICKET_ID=" + TROUBLE_TICKET_ID + ", INTERNAL_ALARM=" + INTERNAL_ALARM + ", EXTRA_TEXT=" + EXTRA_TEXT + ", USER_ADDITIONAL_INFO=" + USER_ADDITIONAL_INFO + ", SUPPLEMENTARY_INFO=" + SUPPLEMENTARY_INFO + ", DIAGNOSTIC_INFO=" + DIAGNOSTIC_INFO + ", ADDITIONAL_TEXT5=" + ADDITIONAL_TEXT5 + ", ADDITIONAL_TEXT6=" + ADDITIONAL_TEXT6 + ", ADDITIONAL_TEXT7=" + ADDITIONAL_TEXT7 + ", PROBABLE_CAUSE=" + PROBABLE_CAUSE + ", NE_GID=" + NE_GID + ", NE_CONT_GID=" + NE_CONT_GID + ", CORRELATED_ALARM=" + CORRELATED_ALARM + ", CORRELATING_ALARM=" + CORRELATING_ALARM + ", UPDATE_TIMESTAMP=" + UPDATE_TIMESTAMP + ", CORRELATOR_CREATED=" + CORRELATOR_CREATED + ", PIPE_KEY=" + PIPE_KEY + ", DELETED_BY=" + DELETED_BY + ", NOTES_INDICATOR=" + NOTES_INDICATOR + ", ORIGINAL_DN=" + ORIGINAL_DN + ", LIFTED_DN=" + LIFTED_DN + ", ALARM_UPLOAD_SYNC=" + ALARM_UPLOAD_SYNC + ", ADAPTATION_ID=" + ADAPTATION_ID + ", ADAPTATION_RELEASE=" + ADAPTATION_RELEASE + ", OC_ID=" + OC_ID + ", AGENT_ID_TYPE=" + AGENT_ID_TYPE + ", AGENT_ID=" + AGENT_ID + ", ALARM_COUNT=" + ALARM_COUNT + ", TERMINATED_TIME=" + TERMINATED_TIME + "]";
	}
}
