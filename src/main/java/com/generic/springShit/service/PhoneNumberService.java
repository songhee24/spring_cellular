package com.generic.springShit.service;

import com.generic.springShit.entity.PhoneNumber;

import java.util.List;

public interface PhoneNumberService {
    List<PhoneNumber> getAllStudents();

    PhoneNumber getById(Long id);

    PhoneNumber save(PhoneNumber student);
}
