package com.omniwyse.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omniwyse.library.bo.BookStatusBO;

public interface BookStatusRepository extends JpaRepository<BookStatusBO, Long>{

}
