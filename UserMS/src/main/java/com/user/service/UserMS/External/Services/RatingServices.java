package com.user.service.UserMS.External.Services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.user.service.UserMS.Entity.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingServices {
	
	//GET ALL RATING
	@GetMapping("/ratings/getall")
	public Rating getAllRating();
	
	
	//CREATE
	@PostMapping("/ratings/add")
	public Rating createRating(Rating rating);
	
	//GET RATING BY USERID
	@GetMapping("/ratings/{userId}")
	public List<Rating> getRatingByUserId(@PathVariable("userId") String userId);
	
	//GET RATING BY HOTELID
	@GetMapping("/ratings/{hotelId}")
	public List<Rating> getRatingByHotelId(@PathVariable("hotelId") Integer hotelId);
	
	//for put operation
	@PutMapping("/ratings/{ratingId}")
	public List<Rating> updateRating(@PathVariable String ratingId, Rating rating);
	

}
