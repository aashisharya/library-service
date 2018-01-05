package com.omniwyse.library.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omniwyse.library.bo.UserBO;

public interface UserRepository extends JpaRepository<UserBO, Serializable>{
	UserBO findByEmail(String username);
}
