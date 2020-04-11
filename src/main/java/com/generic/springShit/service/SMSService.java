package com.generic.springShit.service;


import com.generic.springShit.entity.SMS;

import java.util.List;

public interface SMSService {
    List<SMS> getAllCalls();

    SMS findById(Long id);

    SMS save(SMS sms);

    void  deleteSMSById(Long id);
}
