package com.user.service.UserMS.Service;

import java.util.List;
import com.user.service.UserMS.Entity.User;

public interface UserService {

	// add new user details
	User createUser(User user);

	// get all user details
	List<User> getAllUser();

	// get particular user by user id
	User getUserById(String userId);

	// delete user by id
	void deleteUserById(String userId);

}
