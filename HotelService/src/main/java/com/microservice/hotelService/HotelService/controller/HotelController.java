package com.microservice.hotelService.HotelService.controller;

import com.microservice.hotelService.HotelService.entities.Hotel;
import com.microservice.hotelService.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getById(@PathVariable String hotelId){
        return ResponseEntity.ok().body(hotelService.getById(hotelId));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAll(){
        return ResponseEntity.ok().body(hotelService.getAll());
    }

    @PutMapping("/update/{hotelId}")
    public ResponseEntity<Hotel> updateUser(@PathVariable String hotelId,@RequestBody Hotel hotel){
        hotel.setId(hotelId);
        try{
            hotelService.update(hotel);
            return ResponseEntity.ok(hotel);
        }catch(IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{hotelId}")
    public ResponseEntity<String> deleteUser(@PathVariable String hotelId){
        try {
            hotelService.deleteById(hotelId);
            return ResponseEntity.ok("Hotel with ID " + hotelId + " has been deleted successfully.");
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }

}
