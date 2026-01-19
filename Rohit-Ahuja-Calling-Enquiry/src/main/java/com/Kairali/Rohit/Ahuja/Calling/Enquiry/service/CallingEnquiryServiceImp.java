package com.Kairali.Rohit.Ahuja.Calling.Enquiry.service;

import com.Kairali.Rohit.Ahuja.Calling.Enquiry.domain.CallingEnquiry;
import com.Kairali.Rohit.Ahuja.Calling.Enquiry.repository.CallingEnquiryRepo;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import jakarta.validation.ValidatorFactory;


import org.springframework.data.domain.Pageable;   // ✅
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class CallingEnquiryServiceImp implements CallingEnquiryService {
    @Autowired
    private CallingEnquiryRepo callingEnquiryRepo;

    public CallingEnquiryServiceImp(CallingEnquiryRepo callingEnquiryRepo) {
        this.callingEnquiryRepo = callingEnquiryRepo;
    }
    @Override
    public ResponseEntity<?> saveCallingEnquiryData(List<CallingEnquiry> callingEnquiryList) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();


        List<CallingEnquiry> valid = new ArrayList<>();
        List<Map<String, String>> failed = new ArrayList<>();


        for (CallingEnquiry m : callingEnquiryList) {
            Set<ConstraintViolation<CallingEnquiry>> error = validator.validate(m);
            if (error.isEmpty()) {
                valid.add(m);
            } else {
                System.out.println("ho");
            }
        }
        callingEnquiryRepo.saveAll(valid);
        return new ResponseEntity<>("Calling data save succesfully", HttpStatus.OK);
    }
    @Override
    public List<CallingEnquiry> getAllById(String id) {
        return callingEnquiryRepo.findAllById(id);
    }
    @Override
    public List<CallingEnquiry> getAllByName(String name) {
        return callingEnquiryRepo.findByNameOfClient(name);
    }
    @Override
    public List<CallingEnquiry> getAllByPhoneNo(String phoneNo) {
        return callingEnquiryRepo.findAllByMobile(phoneNo);
    }
    @Override
    public List<CallingEnquiry> getAllByEmail(String email) {
        return callingEnquiryRepo.findAllByEmailId(email);
    }

    @Override
    public Page<CallingEnquiry> getAll(Pageable page) {
        return callingEnquiryRepo.findAll(page);
    }

}


