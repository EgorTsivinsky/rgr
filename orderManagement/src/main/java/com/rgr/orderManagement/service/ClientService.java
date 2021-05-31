package com.rgr.orderManagement.service;

import com.rgr.orderManagement.entity.Client;

public interface ClientService extends GenericService <Client>{
    Client findByName(String name);
}
