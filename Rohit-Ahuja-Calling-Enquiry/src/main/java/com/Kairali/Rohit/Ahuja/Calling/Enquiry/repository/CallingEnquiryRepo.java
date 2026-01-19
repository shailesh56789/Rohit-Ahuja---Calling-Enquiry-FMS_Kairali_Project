package com.Kairali.Rohit.Ahuja.Calling.Enquiry.repository;

import com.Kairali.Rohit.Ahuja.Calling.Enquiry.domain.CallingEnquiry;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;   // ✅ CORRECT

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface CallingEnquiryRepo extends JpaRepository<CallingEnquiry,String> {
  Page<CallingEnquiry> findAll(Pageable page);
  List<CallingEnquiry> findAllById(String id);
    List<CallingEnquiry> findByNameOfClient(String nameOfClient);
    List<CallingEnquiry> findAllByEmailId(String emailId);
    List<CallingEnquiry> findAllByMobile(String mobile);
}
