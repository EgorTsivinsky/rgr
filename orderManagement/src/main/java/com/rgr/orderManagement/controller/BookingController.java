package com.rgr.orderManagement.controller;

import com.rgr.orderManagement.entity.Booking;
import com.rgr.orderManagement.entity.Client;
import com.rgr.orderManagement.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    @Qualifier("bookingServiceImpl")
    @Autowired
    BookingService bookingService;

    @RequestMapping(value = "/booking/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Booking> getBookingById(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Booking booking = bookingService.findById(id);

        if (booking == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(booking, HttpStatus.OK);
    }


    @RequestMapping(value = "/booking/findBookingByDate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Booking> getBookingByDate(@RequestParam(value = "date") String date) {
        if (date == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Booking booking = bookingService.findByDate(date);

        if (booking == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @RequestMapping(value = "/booking", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
        HttpHeaders headers = new HttpHeaders();
        if (booking == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        bookingService.save(booking);
        return new ResponseEntity<>(booking, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/booking/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Booking> deleteBooking(@PathVariable("id") Long id) {

        Booking booking = bookingService.findById(id);

        if (booking == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        bookingService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/bookings", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = this.bookingService.findAll();

        if (bookings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }
}
