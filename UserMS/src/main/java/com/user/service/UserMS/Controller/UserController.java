package com.user.service.UserMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.UserMS.Entity.User;
import com.user.service.UserMS.Payload.ApiResponse;
import com.user.service.UserMS.Service.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	//create
	@PostMapping("/add")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user1=userServiceImpl.createUser(user);
		return new ResponseEntity<>(user1, HttpStatus.CREATED);
	}
	
	//single user get
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable String userId){
		User user1=this.userServiceImpl.getUserById(userId);
		return new ResponseEntity<>(user1, HttpStatus.OK);
	}
	
	//all user get
	@GetMapping("/getall")
		public ResponseEntity<List<User>> getAllUser(){
		List<User> allUser=this.userServiceImpl.getAllUser();
		return new ResponseEntity<>(allUser, HttpStatus.OK);
	}
	
	//delete user
	@DeleteMapping("/delete/userId")
	public ResponseEntity<ApiResponse> deleteUserById(@PathVariable String userId){
		this.userServiceImpl.deleteUserById(userId);
		return new ResponseEntity<>(new ApiResponse("User deleted successfully !!", true), HttpStatus.OK);
		
	}	
}
