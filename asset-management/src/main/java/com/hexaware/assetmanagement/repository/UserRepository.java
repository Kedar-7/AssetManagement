package com.hexaware.assetmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.assetmanagement.entities.User;




@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {

}
