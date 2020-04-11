package com.generic.springShit.controller;

import com.generic.springShit.entity.Client;
import com.generic.springShit.entity.Operator;
import com.generic.springShit.entity.Rate;
import com.generic.springShit.service.OperatorService;
import com.generic.springShit.service.OperatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operator") // localhost:8080/operator
public class OperatorController {
    @Autowired
    private OperatorService operatorService;

    @GetMapping
    public List<Operator> getAllOperator(){
        return operatorService.getAllOperators();
    }

    @GetMapping("/id")
    @ResponseBody
    public Operator getOperatorById(@RequestParam Long id){
        return operatorService.getOperatorById(id);
    }

    @PostMapping
    public Operator saveOrUpdate(@RequestBody Operator operator){
        return operatorService.save(operator);
    }

    @DeleteMapping("/id")
    public void deleteOperatorById(@RequestParam Long id){
        operatorService.deleteOperatorById(id);
    }
}
