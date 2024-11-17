package com.microservice.hotelService.HotelService.services;

import com.microservice.hotelService.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {

    //create
    Hotel create(Hotel hotel);

    //get all
    List<Hotel> getAll();

    //get by ID
    Hotel getById(String id);

    //update hotel
    void update(Hotel hotel);

    //delete by Id
    void deleteById(String id);
}
