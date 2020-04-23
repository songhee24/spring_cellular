package com.generic.springShit.service.Impl;

import com.generic.springShit.entity.PhoneNumber;
import com.generic.springShit.repository.PhoneNumberRepository;
import com.generic.springShit.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

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
        return phoneNumberRepository.save(c);
    }
}
