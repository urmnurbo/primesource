package com.primesource.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.primesource.restapi.model.User;

public interface UserRepository extends JpaRepository<User, Long >{
    List<User> findByUsernameContainingIgnoreCase(String username);
}
