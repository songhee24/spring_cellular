package com.generic.springShit.service;

import com.generic.springShit.entity.Client;
import java.util.List;

public interface ClientService {
    List<Client> getAllClients();

    Client getClientById(Long id);

    Client save(Client c);
}
