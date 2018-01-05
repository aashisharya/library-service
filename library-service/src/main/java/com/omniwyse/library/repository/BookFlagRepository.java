package com.omniwyse.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omniwyse.library.bo.BookFlagBO;

public interface BookFlagRepository extends JpaRepository<BookFlagBO, Long>{

}
