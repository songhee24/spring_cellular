package com.generic.springShit.service;

import com.generic.springShit.entity.Client;
import com.generic.springShit.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElse(new Client());
    }

    @Override
    public Client save(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }
}
