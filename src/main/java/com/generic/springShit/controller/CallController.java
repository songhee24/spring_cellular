package com.generic.springShit.controller;


import com.generic.springShit.entity.Call;
import com.generic.springShit.service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/call") // localhost:8080/call
public class CallController {
       @Autowired
       private CallService callService;

       @GetMapping
       public List<Call> getAll(){
              return callService.getAllCalls();
       };

       @PostMapping
        public Call create(@RequestBody Call call){
              return callService.save(call);
       }

       @GetMapping("/id")
       @ResponseBody
       public Call findById(Long id){
           return  callService.findById(id);
       }

       @DeleteMapping("/id")
       public void deleteById(@RequestParam Long id){
             callService.deleteCallById(id);
       }

       @PostMapping("/createCall")
       public Call createCall(@RequestBody Call call){
           return callService.createCall(call);
       }



}
