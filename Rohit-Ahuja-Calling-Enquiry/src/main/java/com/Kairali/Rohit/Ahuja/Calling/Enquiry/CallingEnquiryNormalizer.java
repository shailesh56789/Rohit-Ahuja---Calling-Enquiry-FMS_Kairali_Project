package com.Kairali.Rohit.Ahuja.Calling.Enquiry.normalization;

import com.Kairali.Rohit.Ahuja.Calling.Enquiry.domain.CallingEnquiry;
import com.Kairali.Rohit.Ahuja.Calling.Enquiry.dto.CallingEnquirySheetDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class CallingEnquiryNormalizer {
    public CallingEnquiry toEntity(CallingEnquirySheetDTO d) {

        CallingEnquiry e = new CallingEnquiry();

        e.setId(str(d.id));
        e.setNameOfClient(str(d.nameOfClient));
        e.setMobile(str(d.mobile));
        e.setEmailId(str(d.emailId));
        e.setSubject(str(d.subject));
        e.setNotes(str(d.notes));
        e.setIvrUrl(str(d.ivrUrl));
        e.setWebsiteName(str(d.websiteName));
        e.setDataSource(str(d.dataSource));
        e.setAssignToMr(str(d.assignToMr));
        e.setRemarksHistory(str(d.remarksHistory));

        e.setPlanned(date(d.planned));
        e.setActual(date(d.actual));
        e.setTimeDelay(date(d.timeDelay));
        e.setFollowupDate(date(d.followupDate));

        e.setStatus(str(d.status));
        e.setSampleNew_Order_Form_Link(str(d.SampleNew_Order_Form_Link));
        e.setFollowup(str(d.followup));
        e.setRemarks(str(d.remarks));

        e.setTransferTo(str(d.transferTo));
        e.setDefaultContactNo(str(d.defaultContactNo));
        e.setDefaultEmailId(str(d.defaultEmailId));

        e.setEmailSent(bool(d.emailSent));
        e.setWhatsappSent(bool(d.whatsappSent));
        e.setSmsSent(bool(d.smsSent));
        e.setDuplicate(bool(d.duplicate));
        e.setTransferToSqlTable(bool(d.transferToSqlTable));

        e.setCount_id(str(d.count_id));
        e.setEmailSentStatus(str(d.emailSentStatus));
        e.setWhatsappSentStatus(str(d.whatsappSentStatus));
        e.setSmsSentStatus(str(d.smsSentStatus));
        e.setOrder_sales_saved_status(str(d.order_sales_saved_status));

        e.setFromSheet(str(d.fromSheet));
        e.setBlank1(str(d.blank1));
        e.setBlank2(str(d.blank2));
        e.setBlank3(str(d.blank3));
        e.setBlank4(str(d.blank4));
        e.setBlank5(str(d.blank5));
        e.setBlank6(str(d.blank6));

        e.setSqvLeadIntent(str(d.sqvLeadIntent));
        e.setLeadPriority(str(d.leadPriority));
        e.setClientCategory(str(d.clientCategory));

        e.setGoogleDriveCallRecordingUrl(str(d.googleDriveCallRecordingUrl));
        e.setFileSize(str(d.fileSize));
        e.setRecordingNotFoundException(str(d.recordingNotFoundException));
        e.setNbdCrrCall(str(d.nbdCrrCall));

        e.setTimeStamp(dateTime(d.timeStamp));
        e.setDateTime(dateTime(d.dateTime));
        e.setCallTime(dateTime(d.callTime));

        return e;
    }

    /* -------- helpers -------- */

    private String str(Object o) {
        if (o == null) return null;
        String s = o.toString().trim();
        return s.isEmpty() || s.equalsIgnoreCase("NA") ? null : s;
    }

    private Boolean bool(Object o) {
        if (o == null) return null;
        String s = o.toString().trim();
        if (s.isEmpty() || s.equalsIgnoreCase("NA")) return null;
        return s.equalsIgnoreCase("true")
                || s.equalsIgnoreCase("yes")
                || s.equals("1");
    }

    private LocalDate date(Object o) {
        try {
            return o == null ? null
                    : LocalDate.parse(o.toString().substring(0, 10));
        } catch (Exception e) {
            return null;
        }
    }

    private LocalDateTime dateTime(Object o) {
        try {
            return o == null ? null
                    : LocalDateTime.parse(o.toString().replace("Z", ""));
        } catch (Exception e) {
            return null;
        }
    }
}
