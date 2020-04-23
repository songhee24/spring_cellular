package com.generic.springShit.service.Impl;

import com.generic.springShit.entity.Call;
import com.generic.springShit.entity.Operator;
import com.generic.springShit.entity.PhoneNumber;
import com.generic.springShit.entity.SMS;
import com.generic.springShit.repository.CallRepository;
import com.generic.springShit.service.CallService;
import com.generic.springShit.service.OperatorService;
import com.generic.springShit.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.net.CacheRequest;
import java.util.List;
import java.util.Optional;

@Service
public class CallServiceImpl implements CallService {
    @Autowired
    CallRepository callRepository;
    @Autowired
    OperatorService operatorService;
    @Autowired
    PhoneNumberService phoneNumberService;

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
        Call call1 = callRepository.findById(call.getId()).orElse(null);
        if (call1 == null){
            Operator operator = operatorService.getOperatorById(call.
                    getAcceptingCallNumber().getRate().getOperatorId().getId());
            PhoneNumber phoneNumber = phoneNumberService.getPhoneNumberById(call.getAcceptingCallNumber().getId());
            Double sum = call.getAcceptingCallNumber().getRate()
                    .getForCall() * call.getMinutes();
            operator.setOpGetMoney(operator.getOpGetMoney().
                    add(BigDecimal.valueOf(sum)));
            operator.setMoneyInPhones(operator.getOpGetMoney().subtract(BigDecimal.valueOf(sum)));
            operatorService.save(operator);
            phoneNumber.setAmount(phoneNumber.getAmount() - sum);
            phoneNumberService.save(phoneNumber);
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
