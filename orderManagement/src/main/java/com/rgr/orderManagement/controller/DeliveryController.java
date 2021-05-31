package com.rgr.orderManagement.controller;

import com.rgr.orderManagement.entity.Client;
import com.rgr.orderManagement.entity.Delivery;
import com.rgr.orderManagement.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeliveryController {

    @Qualifier("deliveryServiceImpl")
    @Autowired
    DeliveryService deliveryService;

    @RequestMapping(value = "/delivery/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Delivery> getDeliveryById(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Delivery delivery = deliveryService.findById(id);

        if (delivery == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(delivery, HttpStatus.OK);
    }


    @RequestMapping(value = "/delivery/findDeliveryByName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Delivery> getDeliveryByName(@RequestParam(value = "name") String name) {
        if (name == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Delivery delivery = deliveryService.findByName(name);

        if (delivery == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(delivery, HttpStatus.OK);
    }

    @RequestMapping(value = "/delivery", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Delivery> addDelivery(@RequestBody Delivery delivery) {
        HttpHeaders headers = new HttpHeaders();
        if (delivery == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        deliveryService.save(delivery);
        return new ResponseEntity<>(delivery, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/delivery/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> deleteDelivery(@PathVariable("id") Long id) {

        Delivery delivery = deliveryService.findById(id);

        if (delivery == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        deliveryService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/deliveries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Delivery>> getAllDeliveries() {
        List<Delivery> deliveries = deliveryService.findAll();

        if (deliveries.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(deliveries, HttpStatus.OK);
    }
}
