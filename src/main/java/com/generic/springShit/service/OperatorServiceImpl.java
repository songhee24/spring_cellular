package com.generic.springShit.service;

import com.generic.springShit.entity.Operator;
import com.generic.springShit.repository.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperatorServiceImpl implements OperatorService{
    @Autowired
    private OperatorRepository operatorRepository;

    @Override
    public List<Operator> getAllOperators() {
        return operatorRepository.findAll();
    }

    @Override
    public Operator getOperatorById(Long id) {
        Optional<Operator> operator = operatorRepository.findById(id);
        return operator.orElse(new Operator());
    }

    @Override
    public Operator save(Operator c) {
        return operatorRepository.save(c);
    }

    @Override
    public void deleteOperatorById(Long id) {
        operatorRepository.deleteById(id);
    }
}
