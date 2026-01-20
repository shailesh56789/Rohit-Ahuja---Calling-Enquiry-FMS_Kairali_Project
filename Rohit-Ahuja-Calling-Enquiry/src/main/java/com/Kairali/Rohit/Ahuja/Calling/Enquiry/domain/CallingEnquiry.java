package com.Kairali.Rohit.Ahuja.Calling.Enquiry.domain;

import com.Kairali.Rohit.Ahuja.Calling.Enquiry.annotation.AutoTrim;
import com.Kairali.Rohit.Ahuja.Calling.Enquiry.listener.AutoTrimListener;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="Rohit_Ahuja-Calling Enquiry_Table")
@EntityListeners(AutoTrimListener.class)
public class CallingEnquiry implements Serializable {
    @Column(name = "time_stamp")
    private LocalDateTime timeStamp;
    @Column(name = "date_time")
    private LocalDateTime dateTime;
    @Id
    @Column(name = "id",nullable = false)
    @AutoTrim(max = 30)
    private String id;
    @Column(name = "name_of_client")
    @AutoTrim(max = 35)
    private String nameOfClient;
    @Column(name = "mobile")
    @AutoTrim(max = 25)
    private String mobile;
    @Column(name = "email_id")
    @AutoTrim(max = 50)
    private String emailId;
    @Column(name = "subject")
    @AutoTrim(max = 255)
    private String subject;
    @Column(name = "notes", columnDefinition = "TEXT")
    @AutoTrim(max = 1025)
    private String notes;
    @Column(name = "ivr_url")
    @AutoTrim(max = 225)
    private String ivrUrl;
    @Column(name = "website_name")
    @AutoTrim(max = 100)
    private String websiteName;
    @Column(name = "data_source")
    @AutoTrim(max = 100)
    private String dataSource;
    @Column(name = "assign_to_mr")
    @AutoTrim(max = 60)
    private String assignToMr;
    @Column(name = "remarks_history", columnDefinition = "TEXT")
    @AutoTrim(max = 1025)
    private String remarksHistory;
    @Column(name = "planned_date")
    private LocalDate planned;
    @Column(name = "actual_date")
    private LocalDate actual;
    @Column(name = "time_delay")
    private LocalDate timeDelay;
    @Column(name = "status")
    @AutoTrim(max = 55)
    private String status;
    @Column(name = "SampleNew_Order_Form_Link")
    @AutoTrim(max = 225)
    private String SampleNew_Order_Form_Link;  //?
    @Column(name = "followup")
    @AutoTrim(max = 225)
    private String followup;
    @Column(name = "remarks", columnDefinition = "TEXT")
    @AutoTrim(max = 211)
    private String remarks;
    @Column(name = "followup_date")
    private LocalDate followupDate;
    @Column(name = "transfer_to")
    @AutoTrim(max = 55)
    private String transferTo;
    @Column(name = "default_contact_no")
    @AutoTrim(max = 55)
    private String defaultContactNo;
    @Column(name = "default_email_id")
    @AutoTrim(max = 55)
    private String defaultEmailId;
    // ---------- Communication Flags ----------
    @Column(name = "email_sent")
    private Boolean emailSent;
    @Column(name = "whatsapp_sent")
    private Boolean whatsappSent;
    @Column(name = "sms_sent")
    private Boolean smsSent;
    @Column(name = "count_id")
    @AutoTrim(max = 55)
    private String count_id;
    @Column(name = "email_sent_status")
    @AutoTrim(max = 55)
    private String emailSentStatus;
    @Column(name = "whatsapp_sent_status")
    @AutoTrim(max = 55)
    private String whatsappSentStatus;
    @Column(name = "sms_sent_status")
    @AutoTrim(max = 55)
    private String smsSentStatus;
    @Column(name = "order_sales_saved_staus")
    @AutoTrim(max = 55)
    private String order_sales_saved_status;
    // ---------- Status ----------
    @Column(name="from_sheet")
    @AutoTrim(max = 55)
    private String fromSheet;
    @Column(name = "blank1")
    @AutoTrim(max = 55)
    private String blank1;

    // ---------- Lead Details ----------
    @Column(name = "sqv_lead_intent")
    @AutoTrim(max = 55)
    private String sqvLeadIntent;
    @Column(name = "lead_priority")
    @AutoTrim(max = 55)
    private String leadPriority;
    @Column(name = "duplicate")
    @AutoTrim(max = 55)
    private Boolean duplicate;
    @Column(name = "client_category")
    @AutoTrim(max = 55)
    private String clientCategory;

    //-----------cheking
    @Column(name = "blank2")
    @AutoTrim(max = 55)
    private String blank2;
    @Column(name = "blank3")
    @AutoTrim(max = 55)
    private String blank3;
    @Column(name = "blank4")
    @AutoTrim(max = 55)
    private String blank4;
    @Column(name = "blank5")
    @AutoTrim(max = 55)
    private String blank5;
    @Column(name = "blank6")
    @AutoTrim(max = 55)
    private String blank6;
    @Column(name = "transfer_to_sql_table")
    private Boolean transferToSqlTable;

    @Column(name = "google_drive_call_recording_url")
    @AutoTrim(max=55)
    private String googleDriveCallRecordingUrl;

    @Column(name = "blank7")
    @AutoTrim(max = 55)
    private Boolean blank7;
    @Column(name = "call_time")
    private LocalDateTime callTime;
    @Column(name = "file_size")
    @AutoTrim(max =55)
    private String fileSize;

    @Column(name = "recording_not_found_exception")
    @AutoTrim(max =55)
    private String recordingNotFoundException;

    @Column(name = "nbd_crr_call")
    @AutoTrim(max =55)
    private String nbdCrrCall;
    //-----------cheking


    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameOfClient() {
        return nameOfClient;
    }

    public void setNameOfClient(String nameOfClient) {
        this.nameOfClient = nameOfClient;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getIvrUrl() {
        return ivrUrl;
    }

    public void setIvrUrl(String ivrUrl) {
        this.ivrUrl = ivrUrl;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getAssignToMr() {
        return assignToMr;
    }

    public void setAssignToMr(String assignToMr) {
        this.assignToMr = assignToMr;
    }

    public String getRemarksHistory() {
        return remarksHistory;
    }

    public void setRemarksHistory(String remarksHistory) {
        this.remarksHistory = remarksHistory;
    }

    public LocalDate getPlanned() {
        return planned;
    }

    public void setPlanned(LocalDate planned) {
        this.planned = planned;
    }

    public LocalDate getActual() {
        return actual;
    }

    public void setActual(LocalDate actual) {
        this.actual = actual;
    }

    public LocalDate getTimeDelay() {
        return timeDelay;
    }

    public void setTimeDelay(LocalDate timeDelay) {
        this.timeDelay = timeDelay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSampleNew_Order_Form_Link() {
        return SampleNew_Order_Form_Link;
    }

    public void setSampleNew_Order_Form_Link(String sampleNew_Order_Form_Link) {
        SampleNew_Order_Form_Link = sampleNew_Order_Form_Link;
    }

    public String getFollowup() {
        return followup;
    }

    public void setFollowup(String followup) {
        this.followup = followup;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDate getFollowupDate() {
        return followupDate;
    }

    public void setFollowupDate(LocalDate followupDate) {
        this.followupDate = followupDate;
    }

    public String getTransferTo() {
        return transferTo;
    }

    public void setTransferTo(String transferTo) {
        this.transferTo = transferTo;
    }

    public String getDefaultContactNo() {
        return defaultContactNo;
    }

    public void setDefaultContactNo(String defaultContactNo) {
        this.defaultContactNo = defaultContactNo;
    }

    public String getDefaultEmailId() {
        return defaultEmailId;
    }

    public void setDefaultEmailId(String defaultEmailId) {
        this.defaultEmailId = defaultEmailId;
    }

    public Boolean getEmailSent() {
        return emailSent;
    }

    public void setEmailSent(Boolean emailSent) {
        this.emailSent = emailSent;
    }

    public Boolean getWhatsappSent() {
        return whatsappSent;
    }

    public void setWhatsappSent(Boolean whatsappSent) {
        this.whatsappSent = whatsappSent;
    }

    public Boolean getSmsSent() {
        return smsSent;
    }

    public void setSmsSent(Boolean smsSent) {
        this.smsSent = smsSent;
    }

    public String getCount_id() {
        return count_id;
    }

    public void setCount_id(String count_id) {
        this.count_id = count_id;
    }

    public String getEmailSentStatus() {
        return emailSentStatus;
    }

    public void setEmailSentStatus(String emailSentStatus) {
        this.emailSentStatus = emailSentStatus;
    }

    public String getWhatsappSentStatus() {
        return whatsappSentStatus;
    }

    public void setWhatsappSentStatus(String whatsappSentStatus) {
        this.whatsappSentStatus = whatsappSentStatus;
    }

    public String getSmsSentStatus() {
        return smsSentStatus;
    }

    public void setSmsSentStatus(String smsSentStatus) {
        this.smsSentStatus = smsSentStatus;
    }

    public String getOrder_sales_saved_status() {
        return order_sales_saved_status;
    }

    public void setOrder_sales_saved_status(String order_sales_saved_status) {
        this.order_sales_saved_status = order_sales_saved_status;
    }

    public String getFromSheet() {
        return fromSheet;
    }

    public void setFromSheet(String fromSheet) {
        this.fromSheet = fromSheet;
    }

    public String getBlank1() {
        return blank1;
    }

    public void setBlank1(String blank1) {
        this.blank1 = blank1;
    }

    public String getSqvLeadIntent() {
        return sqvLeadIntent;
    }

    public void setSqvLeadIntent(String sqvLeadIntent) {
        this.sqvLeadIntent = sqvLeadIntent;
    }

    public String getLeadPriority() {
        return leadPriority;
    }

    public void setLeadPriority(String leadPriority) {
        this.leadPriority = leadPriority;
    }

    public Boolean getDuplicate() {
        return duplicate;
    }

    public void setDuplicate(Boolean duplicate) {
        this.duplicate = duplicate;
    }

    public String getClientCategory() {
        return clientCategory;
    }

    public void setClientCategory(String clientCategory) {
        this.clientCategory = clientCategory;
    }

    public String getBlank2() {
        return blank2;
    }

    public void setBlank2(String blank2) {
        this.blank2 = blank2;
    }

    public String getBlank3() {
        return blank3;
    }

    public void setBlank3(String blank3) {
        this.blank3 = blank3;
    }

    public String getBlank4() {
        return blank4;
    }

    public void setBlank4(String blank4) {
        this.blank4 = blank4;
    }

    public String getBlank5() {
        return blank5;
    }

    public void setBlank5(String blank5) {
        this.blank5 = blank5;
    }

    public String getBlank6() {
        return blank6;
    }

    public void setBlank6(String blank6) {
        this.blank6 = blank6;
    }

    public Boolean getTransferToSqlTable() {
        return transferToSqlTable;
    }

    public void setTransferToSqlTable(Boolean transferToSqlTable) {
        this.transferToSqlTable = transferToSqlTable;
    }

    public String getGoogleDriveCallRecordingUrl() {
        return googleDriveCallRecordingUrl;
    }

    public void setGoogleDriveCallRecordingUrl(String googleDriveCallRecordingUrl) {
        this.googleDriveCallRecordingUrl = googleDriveCallRecordingUrl;
    }

    public Boolean getBlank7() {
        return blank7;
    }

    public void setBlank7(Boolean blank7) {
        this.blank7 = blank7;
    }

    public LocalDateTime getCallTime() {
        return callTime;
    }

    public void setCallTime(LocalDateTime callTime) {
        this.callTime = callTime;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getRecordingNotFoundException() {
        return recordingNotFoundException;
    }

    public void setRecordingNotFoundException(String recordingNotFoundException) {
        this.recordingNotFoundException = recordingNotFoundException;
    }

    public String getNbdCrrCall() {
        return nbdCrrCall;
    }

    public void setNbdCrrCall(String nbdCrrCall) {
        this.nbdCrrCall = nbdCrrCall;
    }
}
