package com.generic.springShit.service;

import com.generic.springShit.entity.Client;
import com.generic.springShit.entity.PhoneNumber;

import java.util.List;

public interface PhoneNumberService {
    List<PhoneNumber> getAllPhoneNumber();

    PhoneNumber getPhoneNumberById(Long id);

    PhoneNumber save(PhoneNumber c);
}
