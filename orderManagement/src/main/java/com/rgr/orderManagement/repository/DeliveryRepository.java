package com.rgr.orderManagement.repository;

import com.rgr.orderManagement.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "delivery", path = "delivery")
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    Delivery findDeliveryById(Long id);

    Delivery findDeliveryByName(String name);
}
