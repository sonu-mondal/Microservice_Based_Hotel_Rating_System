package com.rating.RatingMS.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document("user_ratings")
public class Rating {
	
	@Id
	private String ratingId;
	private int hotelId;
	private String userId;
	private int rating;
	private String feedback;

}
