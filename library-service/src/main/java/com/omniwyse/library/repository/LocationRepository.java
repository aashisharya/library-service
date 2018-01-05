package com.omniwyse.library.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omniwyse.library.bo.LibraryLocationBO;

public interface LocationRepository extends JpaRepository<LibraryLocationBO, Serializable>{

}
