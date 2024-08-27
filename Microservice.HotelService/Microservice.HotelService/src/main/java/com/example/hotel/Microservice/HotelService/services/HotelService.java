package com.example.hotel.Microservice.HotelService.services;

import com.example.hotel.Microservice.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel create(Hotel hotel);

    List<Hotel> getAll();


    Hotel get(String id);

}
