package com.rgr.orderManagement.service.impl;

import com.rgr.orderManagement.entity.Delivery;
import com.rgr.orderManagement.repository.DeliveryRepository;
import com.rgr.orderManagement.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    @Override
    public Delivery findByName(String name) {
        return deliveryRepository.findDeliveryByName(name);
    }

    @Override
    public void save(Delivery delivery) {
        deliveryRepository.save(delivery);
    }

    @Override
    public List<Delivery> findAll() {
        return deliveryRepository.findAll();
    }

    @Override
    public Delivery findById(Long id) {
        return deliveryRepository.findDeliveryById(id);
    }

    @Override
    public void delete(Long id) {
        deliveryRepository.deleteById(id);
    }
}
