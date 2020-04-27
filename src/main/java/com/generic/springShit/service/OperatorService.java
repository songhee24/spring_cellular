package com.generic.springShit.service;

import com.generic.springShit.entity.Operator;

import java.util.List;

public interface OperatorService {
    List<Operator> getAllOperators();

    Operator getOperatorById(Long id);

    Operator save(Operator c);

    void deleteOperatorById(Long id);

}
