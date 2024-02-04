package com.hexaware.assetmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.assetmanagement.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
