package com.generic.springShit.service.Impl;

import com.generic.springShit.entity.Call;
import com.generic.springShit.entity.Operator;
import com.generic.springShit.entity.PhoneNumber;
import com.generic.springShit.entity.SMS;
import com.generic.springShit.repository.SMSRepository;
import com.generic.springShit.service.OperatorService;
import com.generic.springShit.service.PhoneNumberService;
import com.generic.springShit.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class SMSServiceImpl implements SMSService {
    @Autowired
    SMSRepository smsRepository;
    @Autowired
    OperatorService operatorService;
    @Autowired
    PhoneNumberService phoneNumberService;

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
    public SMS createSMS(SMS sms) {
        SMS call1 = smsRepository.findById(sms.getId()).orElse(null);
        if (call1 == null){
            Operator operator = operatorService.getOperatorById(sms.getAcceptingSms()
                    .getRate().getOperatorId().getId());
            PhoneNumber phoneNumber = phoneNumberService.getPhoneNumberById(sms.getAcceptingSms().getId());
            Double sum = sms.getAcceptingSms().getRate().getForSMS();
            operator.setOpGetMoney(operator.getOpGetMoney().
                    add(BigDecimal.valueOf(sum)));
            operator.setMoneyInPhones(operator.getOpGetMoney().subtract(BigDecimal.valueOf(sum)));
            operatorService.save(operator);
            phoneNumber.setAmount(phoneNumber.getAmount() - sum);
            phoneNumberService.save(phoneNumber);
            return smsRepository.save(sms);
        }
        return sms;
    }

    @Override
    public void deleteSMSById(Long id) {
        smsRepository.deleteById(id);
    }
}
