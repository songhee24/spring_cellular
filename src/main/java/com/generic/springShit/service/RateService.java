package com.generic.springShit.service;

import com.generic.springShit.entity.Operator;
import com.generic.springShit.entity.Rate;

import java.util.List;

public interface RateService{
    List<Rate> getAllRate();

    Rate getRateById(Long id);

    Rate save(Rate c);

    void deleteRateById(Long id);
}
