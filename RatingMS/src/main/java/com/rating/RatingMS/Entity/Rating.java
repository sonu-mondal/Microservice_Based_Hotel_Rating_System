package com.rating.RatingMS.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document("user_ratings")
public class Rating {
	
	@Id
	private String ratingId;
	private int hotelId;
	private String userId;
	private int rating;
	private String feedback;
	public String getRatingId() {
		return ratingId;
	}
	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Rating(String ratingId, int hotelId, String userId, int rating, String feedback) {
		super();
		this.ratingId = ratingId;
		this.hotelId = hotelId;
		this.userId = userId;
		this.rating = rating;
		this.feedback = feedback;
	}
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}

}
