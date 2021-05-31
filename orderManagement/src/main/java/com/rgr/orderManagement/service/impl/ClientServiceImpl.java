package com.rgr.orderManagement.service.impl;

import com.rgr.orderManagement.entity.Client;
import com.rgr.orderManagement.repository.ClientRepository;
import com.rgr.orderManagement.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Client findByName(String name) {
        return clientRepository.findClientByName(name);
    }

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findClientById(id);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
