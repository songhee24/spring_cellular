package com.generic.springShit.service;

import com.generic.springShit.entity.Operator;
import com.generic.springShit.entity.Rate;
import com.generic.springShit.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RateServiceImpl implements RateService{
    @Autowired
    private RateRepository rateRepository;

    @Override
    public List<Rate> getAllRate() {
        return rateRepository.findAll();
    }

    @Override
    public Rate getRateById(Long id) {
        Optional<Rate> rate = rateRepository.findById(id);
        return rate.orElse(new Rate());
    }

    @Override
    public Rate save(Rate c) {
        return rateRepository.save(c);
    }

    @Override
    public void deleteRateById(Long id) {
        rateRepository.deleteById(id);
    }
}
