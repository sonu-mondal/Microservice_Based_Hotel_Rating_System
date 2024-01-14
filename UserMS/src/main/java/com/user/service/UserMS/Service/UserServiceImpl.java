package com.user.service.UserMS.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.UserMS.Entity.User;
import com.user.service.UserMS.Exception.ResourceNotFoundException;
import com.user.service.UserMS.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		//it will generate a unique user thast is same as we do using @generatedValue annotation in entity class
		String randomUserId=UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(String userId) {
//so if the userid is present in the database then it will fetch else it will throw exception and that exception we need to handle globally so we need to create a global exception handler class in exception package		
		return userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id is not found on server !! : "+userId));	
	}

	@Override
	public void deleteUserById(String userId) {
		User user=this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id is not found on server !! : "+userId));
		  userRepository.delete(user);
		
	}

}
