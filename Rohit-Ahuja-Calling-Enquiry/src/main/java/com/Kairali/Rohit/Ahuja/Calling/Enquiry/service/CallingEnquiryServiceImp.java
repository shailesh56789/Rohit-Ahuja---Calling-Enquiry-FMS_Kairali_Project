package com.Kairali.Rohit.Ahuja.Calling.Enquiry.service;

import com.Kairali.Rohit.Ahuja.Calling.Enquiry.domain.CallingEnquiry;
import com.Kairali.Rohit.Ahuja.Calling.Enquiry.dto.CallingEnquirySheetDTO;
import com.Kairali.Rohit.Ahuja.Calling.Enquiry.normalization.CallingEnquiryNormalizer;
import com.Kairali.Rohit.Ahuja.Calling.Enquiry.repository.CallingEnquiryRepo;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import jakarta.validation.ValidatorFactory;


import org.springframework.data.domain.Pageable;   // ✅
import org.springframework.data.domain.PageRequest;

import java.util.*;

import static java.lang.Math.log;

@Service
public class CallingEnquiryServiceImp implements CallingEnquiryService {
    private static final Logger log = LogManager.getLogger(CallingEnquiryServiceImp.class);
    @Autowired
    private CallingEnquiryRepo callingEnquiryRepo;
    private final CallingEnquiryNormalizer normalizer;

    public CallingEnquiryServiceImp(CallingEnquiryRepo callingEnquiryRepo,CallingEnquiryNormalizer normalizer) {
        this.callingEnquiryRepo = callingEnquiryRepo;
        this.normalizer=normalizer;
    }
    public void save1(List<CallingEnquiry>  Ldata)
    {
        Map<String,CallingEnquiry>  uniqueEnquiry = new  LinkedHashMap<>();
        int duplicateCount=0;
        for(CallingEnquiry data :Ldata)
        {
            if(uniqueEnquiry.containsKey(data.getId()))
            {
                duplicateCount++;
                log.warn("Duplicate ID found and will be overwritten: {} (Name: {})", data.getId(), data.getNameOfClient());
            }
            //store first value and ignore remaining duplicates
            uniqueEnquiry.putIfAbsent(data.getId(),data);

        }
        log.info("Found {} duplicates, saving {} unique records",
                duplicateCount, uniqueEnquiry.size());
        //*************************updated version code*****************************************************
        callingEnquiryRepo.saveAll(uniqueEnquiry.values());
       // callingEnquiryRepo.saveAll(Ldata);
    }
    public void saveFromSheet(List<CallingEnquirySheetDTO> sheetData) {
               List<CallingEnquiry> entities = sheetData.stream().map(normalizer::toEntity).toList();
               //callingEnquiryRepo.saveAll(entities);
      //*********************************update version code*************************************************
              // ignore duplicates duplicates
               Map<String,CallingEnquiry>  uniqueEnquiry = new  LinkedHashMap<>();
              int duplicateCount=0;
        for(CallingEnquiry data :entities)
        {
            if(uniqueEnquiry.containsKey(data.getId()))
            {
                duplicateCount++;
                log.warn("Duplicate ID found and will be overwritten: {} (Name: {})", data.getId(), data.getNameOfClient());
            }
            //store first value and ignore remaining duplicates
            uniqueEnquiry.putIfAbsent(data.getId(),data);

        }
        log.info("Found {} duplicates, saving {} unique records",
                duplicateCount, uniqueEnquiry.size());
        //*************************updated version code*****************************************************
        callingEnquiryRepo.saveAll(uniqueEnquiry.values());
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


