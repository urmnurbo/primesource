package com.primesource.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import com.primesource.restapi.model.User;

public interface UserRepository extends JpaRepository<User, Long >{
	/*@Async
    @Query("SELECT * FROM users u where u.username like '%:username%'") */
    List<User> findByUsernameContainingIgnoreCase(String username);
}
