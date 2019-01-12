package com.primesource.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.primesource.restapi.model.User;

public interface UserRepository extends JpaRepository<User, Long >{

}
