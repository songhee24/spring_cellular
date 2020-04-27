package com.generic.springShit.controller;

import com.generic.springShit.entity.PhoneNumber;
import com.generic.springShit.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phone") // localhost:8080/phone
public class PhoneNumberController {
    @Autowired
    private PhoneNumberService phoneNumberService;

    @GetMapping
    public List<PhoneNumber> getAll(){
        return phoneNumberService.getAllPhoneNumber();
    }

    @PostMapping
    public PhoneNumber create(@RequestBody PhoneNumber phoneNumber){
        return phoneNumberService.save(phoneNumber);
    }
}
