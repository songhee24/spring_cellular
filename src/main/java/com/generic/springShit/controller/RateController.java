package com.generic.springShit.controller;

import com.generic.springShit.entity.Operator;
import com.generic.springShit.entity.Rate;
import com.generic.springShit.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rate") // localhost:8080/rate
public class RateController {
    @Autowired
    private RateService rateService;

    @GetMapping
    public List<Rate> getAllOperator(){
        return rateService.getAllRate();
    }

    @GetMapping("/id")
    @ResponseBody
    public Rate getOperatorById(@RequestParam Long id){
        return rateService.getRateById(id);
    }

    @PostMapping
    public Rate saveOrUpdate(@RequestBody Rate rate){
        return rateService.save(rate);
    }

    @DeleteMapping("/id")
    public void deleteOperatorById(@RequestParam Long id){
        rateService.deleteRateById(id);
    }
}
