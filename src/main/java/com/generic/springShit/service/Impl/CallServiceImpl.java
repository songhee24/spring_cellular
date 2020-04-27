package com.generic.springShit.service.Impl;

import com.generic.springShit.entity.*;
import com.generic.springShit.repository.CallRepository;
import com.generic.springShit.service.CallService;
import com.generic.springShit.service.OperatorService;
import com.generic.springShit.service.PhoneNumberService;
import com.generic.springShit.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.net.CacheRequest;
import java.util.List;
import java.util.Optional;

@Service
public class CallServiceImpl implements CallService {
    @Autowired
    private CallRepository callRepository;
    @Autowired
    private OperatorService operatorService;
    @Autowired
    private PhoneNumberService phoneNumberService;
    @Autowired
    private RateService rateService;

    @Override
    public List<Call> getAllCalls() {
        return callRepository.findAll();
    }

    @Override
    public Call findById(Long id) {
        Optional<Call> call = callRepository.findById(id);
        return call.orElse(new Call());
    }

    @Override
    public Call createCall(Call call) {
        if (call.getId() == null){
            PhoneNumber phoneNumber = phoneNumberService.getPhoneNumberById(call.
                    getAcceptingCallNumber().getId());
            PhoneNumber phoneNumber2 = phoneNumberService.getPhoneNumberById(call.
                    getCallingPhoneNumber().getId());
            Rate rate = rateService.getRateById(phoneNumber.getRate().getId());
            Operator operator = operatorService.getOperatorById(phoneNumber
                    .getRate().getOperatorId().getId());
            Double sum = phoneNumber.getRate()
                    .getForCall() * call.getMinutes();
            operator.setOpGetMoney(operator.getOpGetMoney().
                    add(BigDecimal.valueOf(sum)));
            operator.setMoneyInPhones(operator.getOpGetMoney().subtract(BigDecimal.valueOf(sum)));
            operatorService.save(operator);
            phoneNumber.setAmount(phoneNumber.getAmount() - sum);
            phoneNumberService.save(phoneNumber);
            call.setAcceptingCallNumber(phoneNumber);
            call.setCallingPhoneNumber(phoneNumber2);
            return callRepository.save(call);
        }
        return call;
    }

    @Override
    public Call save(Call call) {
        return callRepository.save(call);
    }

    @Override
    public void deleteCallById(Long id) {
        deleteCallById(id);
    }



}
