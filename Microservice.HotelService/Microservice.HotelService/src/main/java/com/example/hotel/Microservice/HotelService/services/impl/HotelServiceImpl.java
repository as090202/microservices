package com.example.hotel.Microservice.HotelService.services.impl;

import com.example.hotel.Microservice.HotelService.entities.Hotel;
import com.example.hotel.Microservice.HotelService.repository.HotelRepository;
import com.example.hotel.Microservice.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).get();
    }
}
