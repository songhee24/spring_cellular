package com.generic.springShit.service;

import com.generic.springShit.entity.PhoneNumber;
import com.generic.springShit.repository.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService{
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Override
    public List<PhoneNumber> getAllStudents() {
        return phoneNumberRepository.findAll();
    }

    @Override
    public PhoneNumber getById(Long id) {
        Optional<PhoneNumber> phoneNumber = phoneNumberRepository.findById(id);
        return phoneNumber.orElse(new PhoneNumber());
    }

    @Override
    public PhoneNumber save(PhoneNumber phoneNumber) {
        return phoneNumberRepository.save(phoneNumber);
    }
}
