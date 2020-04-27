package com.generic.springShit.controller;


import com.generic.springShit.entity.Call;
import com.generic.springShit.entity.SMS;
import com.generic.springShit.service.CallService;
import com.generic.springShit.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sms") // localhost:8080/call
public class SMSController {
    @Autowired
    private SMSService smsService;

    @GetMapping
    public List<SMS> getAll(){
        return smsService.getAllCalls();
    };

    @PostMapping
    public SMS create(@RequestBody SMS sms){
        return smsService.save(sms);
    }

    @GetMapping("/id")
    @ResponseBody
    public SMS findById(Long id){
        return  smsService.findById(id);
    }

    @DeleteMapping("/id")
    public void deleteById(@RequestParam Long id){
        smsService.deleteSMSById(id);
    }

}
