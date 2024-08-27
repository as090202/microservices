package com.example.hotel.Microservice.HotelService.controller;

import com.example.hotel.Microservice.HotelService.entities.Hotel;
import com.example.hotel.Microservice.HotelService.services.HotelService;
import com.example.hotel.Microservice.HotelService.services.impl.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.processing.Generated;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HotelController {
    @Autowired
    private HotelServiceImpl hotelServiceImpl;
@PostMapping("/hotels")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
    return ResponseEntity.status(HttpStatus.CREATED).body(hotelServiceImpl.create(hotel));
}
        @GetMapping("/{hotelId}")
                public ResponseEntity<Hotel> createHotel(@PathVariable String hotelId){
            return ResponseEntity.status(HttpStatus.OK).body(hotelServiceImpl.get(hotelId));

    }
@GetMapping
    public ResponseEntity<List<Hotel>> getAll(){
    return ResponseEntity.ok(hotelServiceImpl.getAll());
    }
}
