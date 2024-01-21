package com.user.service.UserMS.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
	
	private Log logger=LogFactory.getLog(UserServiceImpl.class);

	@Override
	public User createUser(User user) {
		//it will generate a unique user thast is same as we do using @generatedValue annotation in entity class
		String randomUserId=UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
//		List<User> allUser=userRepository.findAll();
//		ArrayList<Rating> ratings=restTemplate.getForObject("http://localhost:9903/ratings/getall/", ArrayList.class);
//		ratings.stream().map(x);
		return null;
	}

	@Override
	public User getUserById(String userId) {
//so if the userid is present in the database then it will fetch else it will throw exception and that exception we need to handle globally so we need to create a global exception handler class in exception package		
		//getting user from database with the help of user repository
		User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id is not found on server !! : "+userId));	
		//fetching rating given by the above user from RATING SERVICE
		//http://localhost:9903/rating/users/8980a1f8-3177-4d38-9947-2ce53f799f6d
		//if we want single object then we can use getforObject or getFor Entity
		//but here we need list of objects																						//here we put what type of data we want since it will return list of values so we put ArrayList.class	
		//Here we are putting hard coded user id /ie static
		//ArrayList<Rating> forObject=restTemplate.getForObject("http://localhost:9903/ratings/users/8980a1f8-3177-4d38-9947-2ce53f799f6d", ArrayList.class);
		
		//Dynamic
		ArrayList<Rating> forObject=restTemplate.getForObject("http://localhost:9903/ratings/users/"+user.getUserId(), ArrayList.class);
		 logger.info(forObject);
		 //now we got particular users rating so we can set the rating details 
		 user.setRatings(forObject);
		return user;
	}

	@Override
	public void deleteUserById(String userId) {
		User user=this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id is not found on server !! : "+userId));
		  userRepository.delete(user);
		
	}

}
