package com.generic.springShit.service.Impl;

import com.generic.springShit.entity.Client;
import com.generic.springShit.entity.Operator;
import com.generic.springShit.entity.PhoneNumber;
import com.generic.springShit.entity.Rate;
import com.generic.springShit.repository.PhoneNumberRepository;
import com.generic.springShit.service.ClientService;
import com.generic.springShit.service.OperatorService;
import com.generic.springShit.service.PhoneNumberService;
import com.generic.springShit.service.RateService;
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
    @Autowired
    private RateService rateService;
    @Autowired
    private ClientService clientService;

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
        Rate rate = rateService.getRateById(c.getRate().getId());
        Client client = clientService.getClientById(c.getClientId().getId());
        System.out.println(rate);
        Operator operator = operatorService.getOperatorById(rate.getOperatorId().getId());
        Double sum = c.getId() == null ? c.getAmount() : c.getAmount()
                - phoneNumberRepository.findById(c.getId()).get().getAmount();
        operator.setMoneyInPhones(operator.getOpGetMoney().subtract(BigDecimal.valueOf(sum)));
        operatorService.save(operator);
        c.setRate(rate);
        c.setClientId(client);
        return phoneNumberRepository.save(c);
    }
}
