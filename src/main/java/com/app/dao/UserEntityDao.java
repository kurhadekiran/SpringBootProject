package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Users;

public interface UserEntityDao extends JpaRepository<Users,Long>{
//derived finder 
	Optional<Users> findByEmail(String email);
}
