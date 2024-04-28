package com.user.service.UserMS.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.UserMS.Entity.Hotel;
import com.user.service.UserMS.Entity.Rating;
import com.user.service.UserMS.Entity.User;
import com.user.service.UserMS.Exception.ResourceNotFoundException;
import com.user.service.UserMS.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

	@Override
	public User createUser(User user) {
		//it will generate a unique user thast is same as we do using @generatedValue annotation in entity class
		String randomUserId=UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override//
	public List<User> getAllUser() {
		List<User> allUser=userRepository.findAll();
//		ArrayList<Rating> ratings=restTemplate.getForObject("http://localhost:9903/ratings/getall/", ArrayList.class);
//		for(User i:allUser) {
//			for(Rating r:ratings) {
//				if(i.getUserId().equals(r.getUserId())) {
//					i.setRatings(r.getRating());
//				}
//			}
//			
//		}
		System.out.println("==================================================================================");
		System.out.println(allUser);
		return allUser;
	}
	
//	@Override//
//	public List<User> getAllUser() {
//		List<User> allUser=userRepository.findAll();
//		Rating[] ratings=restTemplate.getForObject("http://localhost:9903/ratings/getall", Rating[].class);
//		List<Rating> ratings1=Arrays.stream(ratings).toList();
//		List<Rating> ratingList=new ArrayList<>();
//		
//		//for(User i:allUser) {
//			for(Rating r:ratings1) {
//				 ratingList= ratings1.stream().map(rating->{
//					 //Api call to hotel service to get the hotel
//					 //http://localhost:9902/hotels/4
//					ResponseEntity<Hotel> getHotel=restTemplate.getForEntity("http://localhost:9902/hotels/"+rating.getHotelId(), Hotel.class);
//					Hotel hotel=getHotel.getBody();
//					//logger.info(getHotel.getStatusCode());
//					//set the rating to that hotel
//					rating.setHotel(hotel);
//					 //return the rating
//					return rating;
//					 
//				 }).collect(Collectors.toList());
//				
//			}
//			
//			for(User u:allUser) {
//				for(Rating r:ratings1) {
//					if(u.getUserId().equals(r.getUserId())) {
//						u.se
//					}
//				}
//			}
//			
		//}
//		LOGGER.info("====================================================================================");
//		LogManager.getLogger(this.getClass());
//		LOGGER.info(allUser);
//		return allUser;
//	}

	@Override
	public User getUserById(String userId) {
//so if the userid is present in the database then it will fetch else it will throw exception and that exception we need to handle globally so we need to create a global exception handler class in exception package		
		//getting user from database with the help of user repository
		User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id is not found on server !! : "+userId));	
		//fetching rating given by the above user from RATING SERVICE
		//http://localhost:9903/rating/users/8980a1f8-3177-4d38-9947-2ce53f799f6d
		//if we want single object then we can use getforObject or getForEntity
		//but here we need list of objects																						//here we put what type of data we want since it will return list of values so we put ArrayList.class	
		//Here we are putting hard coded user id /ie static
		//ArrayList<Rating> forObject=restTemplate.getForObject("http://localhost:9903/ratings/users/8980a1f8-3177-4d38-9947-2ce53f799f6d", ArrayList.class);
		
		//Dynamic
		Rating[] ratingOfUser=restTemplate.getForObject("http://localhost:9903/ratings/users/"+user.getUserId(), Rating[].class);
		 //logger.info(ratingOfUser);
		 
		List<Rating> ratings=Arrays.stream(ratingOfUser).toList();	
		 
		List<Rating> ratingList= ratings.stream().map(rating->{
			 //Api call to hotel service to get the hotel
			 //http://localhost:9902/hotels/4
			ResponseEntity<Hotel> getHotel=restTemplate.getForEntity("http://localhost:9902/hotels/"+rating.getHotelId(), Hotel.class);
			Hotel hotel=getHotel.getBody();
			//logger.info(getHotel.getStatusCode());
			//set the rating to that hotel
			rating.setHotel(hotel);
			 //return the rating
			return rating;
			 
		 }).collect(Collectors.toList());
		 //now we got particular users rating so we can set the rating details 
		 user.setRatings(ratingList);
		return user;
	}

	@Override
	public void deleteUserById(String userId) {
		User user=this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id is not found on server !! : "+userId));
		  userRepository.delete(user);
		
	}

}
