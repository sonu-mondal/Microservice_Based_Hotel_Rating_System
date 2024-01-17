package com.rating.RatingMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.RatingMS.Entity.Rating;
import com.rating.RatingMS.Service.RatingServiceImpl;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingServiceImpl ratingServiceImpl;
	
	@PostMapping("/add")
	public ResponseEntity<Rating> addRating(@RequestBody Rating rating){
		Rating rating1=this.ratingServiceImpl.addRating(rating);
		return new ResponseEntity<Rating>(rating1, HttpStatus.CREATED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Rating>> getAllRating(){
		List<Rating> getAll=this.ratingServiceImpl.getAllRating();
		return new ResponseEntity<List<Rating>>(getAll, HttpStatus.OK);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getByUserId(@PathVariable String userId){
		List<Rating> rating=this.ratingServiceImpl.getRatingByUserId(userId);
		return new ResponseEntity<List<Rating>>(rating, HttpStatus.OK);
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getByHotelId(@PathVariable int hotelId){
		List<Rating> rating=this.ratingServiceImpl.getRatingByHotelId(hotelId);
		return new ResponseEntity<List<Rating>>(rating, HttpStatus.OK);
	}

}
