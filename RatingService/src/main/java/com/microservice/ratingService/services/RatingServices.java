package com.microservice.ratingService.services;

import com.microservice.ratingService.entities.Rating;

import java.util.List;

public interface RatingServices {


    //create
    Rating create(Rating rating);


    //get all ratings
    List<Rating> getRatings();

    //get all by UserId
    List<Rating> getRatingByUserId(String userId);

    //get all by hotel
    List<Rating> getRatingByHotelId(String hotelId);


}
