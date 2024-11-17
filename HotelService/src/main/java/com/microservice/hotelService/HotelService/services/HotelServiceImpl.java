package com.microservice.hotelService.HotelService.services;

import com.microservice.hotelService.HotelService.entities.Hotel;
import com.microservice.hotelService.HotelService.repositories.HotelRepository;
import com.microservice.hotelService.HotelService.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {
        String hotelId= UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getById(String id) {
        return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel with given id not found on server!!"));
    }

    @Override
    public void update(Hotel hotel) {
        if(!hotelRepository.existsById(hotel.getId())){
            throw new ResourceNotFoundException("Hotel with given id" +hotel.getId() + "not found");
        }
        hotelRepository.save(hotel);

    }

    @Override
    public void deleteById(String id) {
        if (!hotelRepository.existsById(id)){
            throw new ResourceNotFoundException("Hotel with given id" +id+ "not found");
        }
        hotelRepository.deleteById(id);

    }
}
