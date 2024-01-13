package com.user.service.UserMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.service.UserMS.Entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
