package com.rating.RatingMS.Service;

import java.util.List;

import com.rating.RatingMS.Entity.Rating;

public interface RatingService {
	
	//create
	public Rating addRating(Rating rating);
	
	//get all ratings
	public List<Rating> getAllRating();
	
	//get all rating by user id
	List<Rating> getRatingByUserId(String userId);
	
	//get all rating by hotelId
	List<Rating> getRatingByHotelId(int hotelId);
}
