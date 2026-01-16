package com.Kairali.Rohit.Ahuja.Calling.Enquiry.controller;

import com.Kairali.Rohit.Ahuja.Calling.Enquiry.domain.CallingEnquiry;
import com.Kairali.Rohit.Ahuja.Calling.Enquiry.service.CallingEnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CallingEnquiryController {
    @Autowired
    private  final CallingEnquiryService callingEnquiryService;

    public CallingEnquiryController(CallingEnquiryService callingEnquiryService) {
        this.callingEnquiryService = callingEnquiryService;
    }
    @PostMapping("/insert")
    public ResponseEntity<?> insertMarketing(@RequestBody List<CallingEnquiry> callingEnquiryList) {
        callingEnquiryService.saveCallingEnquiryData(callingEnquiryList);
        return new ResponseEntity<>("Calling data saved successfully", HttpStatus.OK);
    }

  /*  @GetMapping(value = "/fetch", produces = "application/json")
    public ResponseEntity<List<CallingEnquiry>> fetchAll()
    {
        return ResponseEntity.ok(callingEnquiryService.);
    }              */
    @GetMapping(value = "/id/{id}", produces = "application/json")
    public ResponseEntity<List<CallingEnquiry>> fetchById(@PathVariable String id)
    {
        //return ResponseEntity.ok(marketService.getAllById(id));
        List<CallingEnquiry> result;


        // 📧 Email check
        if (id.contains("@")) {
            result = callingEnquiryService.getAllByEmail(id);
        }
        // 📱 Phone number check (digits only)
        else if (id.matches("\\d{10}")) {
            result = callingEnquiryService.getAllByPhoneNo(id);
        }
        // 🆔 Otherwise treat as ID
        else {
            result = callingEnquiryService.getAllById(id);
        }


        return ResponseEntity.ok(result);


    }
    /*
    GET /api/marketing/search?keyword=test@gmail.com
GET /api/marketing/search?keyword=9876543210
                http://localhost:8080/api/search?emailId=rahul.sharma@gmail.com
     */
    @GetMapping("/search")
    public ResponseEntity<?> search(
            @RequestParam(required = false) String emailId,
            @RequestParam(required = false) String mobile) {

        if (emailId != null && !emailId.isEmpty()) {
            return ResponseEntity.ok(callingEnquiryService.getAllByEmail(emailId));
        }

        if (mobile != null && !mobile.isEmpty()) {
            return ResponseEntity.ok(callingEnquiryService.getAllByPhoneNo(mobile));
        }

        return ResponseEntity.badRequest()
                .body("Email or Mobile is required");
    }
    //http://localhost:8080/api/name/Rohit Ahuja
    @GetMapping("/name/{nameOfClient}")
    public ResponseEntity<List<CallingEnquiry>> fetchByName(@PathVariable String nameOfClient)
    {
        return  ResponseEntity.ok(callingEnquiryService.getAllByName(nameOfClient));
    }
    //http://localhost:8080/api/email/rohit.ahuja@testmail.com
    @GetMapping(value = "/email/{emailId}",produces = "application/json")
    public ResponseEntity<List<CallingEnquiry>> fetchByEmail(@PathVariable("emailId") String emailId)
    {
        return  ResponseEntity.ok(callingEnquiryService.getAllByEmail(emailId));
    }
    //http://localhost:8080/api/phno/9876543210
    @GetMapping("/phno/{mobile}")
    public ResponseEntity<List<CallingEnquiry>> fetchByPhoneNo(@PathVariable String mobile)
    {
        return  ResponseEntity.ok(callingEnquiryService.getAllByPhoneNo(mobile));
    }

}
