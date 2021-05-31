package com.rgr.orderManagement.repository;

import com.rgr.orderManagement.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "client", path = "client")
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findClientById(Long id);
    Client findClientByName(String name);
}
