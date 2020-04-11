package com.generic.springShit.service;

import com.generic.springShit.entity.SMS;
import com.generic.springShit.repository.SMSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SMSServiceImpl implements SMSService {

    @Autowired
    SMSRepository smsRepository;

    @Override
    public List<SMS> getAllCalls() {
        return smsRepository.findAll();
    }

    @Override
    public SMS findById(Long id) {
        Optional<SMS> sms = smsRepository.findById(id);
        return sms.orElse(new SMS());
    }

    @Override
    public SMS save(SMS sms) {
        return smsRepository.save(sms);
    }

    @Override
    public void deleteSMSById(Long id) {
        smsRepository.deleteById(id);
    }
}
