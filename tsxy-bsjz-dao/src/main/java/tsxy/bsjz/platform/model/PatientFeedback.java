package tsxy.bsjz.platform.model;

import tsxy.bsjz.platform.utils.StringUtil;

import java.util.Date;

public class PatientFeedback {
    private Integer id;

    private Integer patientId;

    private String feedbackContent;

    private Date feedbackDate;

    private String feedbackDateStr;

    //患者 一对一
    private Patient patient;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent == null ? null : feedbackContent.trim();
    }

    public Date getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    public String getFeedbackDateStr() {
        if(feedbackDate != null){
            return StringUtil.dateToString(feedbackDate);
        }
        return "";
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}