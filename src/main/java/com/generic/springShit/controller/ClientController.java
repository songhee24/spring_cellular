package com.generic.springShit.controller;

import com.generic.springShit.entity.Client;
import com.generic.springShit.entity.PhoneNumber;
import com.generic.springShit.repository.ClientRepository;
import com.generic.springShit.service.ClientService;
import com.generic.springShit.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phone") // localhost:8080/phone
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAll(){
        return clientService.getAllClients();
    }

    @PostMapping
    public Client create(@RequestBody Client client){
        return clientService.save(client);
    }
}
