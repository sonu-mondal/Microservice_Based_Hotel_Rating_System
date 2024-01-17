package com.rating.RatingMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.RatingMS.Entity.Rating;
import com.rating.RatingMS.Repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating addRating(Rating rating) {
		return this.ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		return this.ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return this.ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(int hotelId) {
	return this.ratingRepository.findByHotelId(hotelId);
	}

}
