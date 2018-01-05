package com.omniwyse.library.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omniwyse.library.bo.LibraryBO;
import com.omniwyse.library.bo.UserBO;

public interface LibraryRepository extends JpaRepository<LibraryBO, Serializable>{
	LibraryBO findBySuperAdmin(UserBO owner);
	LibraryBO findByName(String libraryName);
}
