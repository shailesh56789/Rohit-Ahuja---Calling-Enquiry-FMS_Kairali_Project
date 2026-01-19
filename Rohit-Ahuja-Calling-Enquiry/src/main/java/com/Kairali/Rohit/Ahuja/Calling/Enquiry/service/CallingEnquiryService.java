package com.Kairali.Rohit.Ahuja.Calling.Enquiry.service;

import com.Kairali.Rohit.Ahuja.Calling.Enquiry.domain.CallingEnquiry;

import org.springframework.boot.data.autoconfigure.web.DataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;   // ✅
import org.springframework.data.domain.PageRequest;

import java.util.List;


public interface CallingEnquiryService {
    public ResponseEntity<?> saveCallingEnquiryData(List<CallingEnquiry> callingEnquiryList);
    public List<CallingEnquiry> getAllById(String id);
    public List<CallingEnquiry> getAllByName(String name);
    public List<CallingEnquiry> getAllByPhoneNo(String phoneNo);
    public List<CallingEnquiry> getAllByEmail(String email);
   public Page<CallingEnquiry> getAll(Pageable pageable);
}
