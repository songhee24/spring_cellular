package com.generic.springShit.service.Impl;

import com.generic.springShit.entity.Operator;
import com.generic.springShit.entity.PhoneNumber;
import com.generic.springShit.repository.PhoneNumberRepository;
import com.generic.springShit.service.OperatorService;
import com.generic.springShit.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;
    @Autowired
    private OperatorService operatorService;

    @Override
    public List<PhoneNumber> getAllPhoneNumber() {
        return phoneNumberRepository.findAll();
    }

    @Override
    public PhoneNumber getPhoneNumberById(Long id) {
        Optional<PhoneNumber> phoneNumber = phoneNumberRepository.findById(id);
        return phoneNumber.orElse(new PhoneNumber());
    }

    @Override
    public PhoneNumber save(PhoneNumber c) {
        PhoneNumber phoneNumber = phoneNumberRepository.findById(c.getId()).orElse(null);
        Operator operator = operatorService.getOperatorById(c.getRate().getOperatorId().getId());
        Double sum = phoneNumber == null ? c.getAmount() : c.getAmount() - phoneNumber.getAmount();
        operator.setMoneyInPhones(operator.getOpGetMoney().subtract(BigDecimal.valueOf(sum)));
        operatorService.save(operator);
        return phoneNumberRepository.save(c);
    }
}
