package com.omniwyse.library.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omniwyse.library.bo.BookBO;
import com.omniwyse.library.bo.BookInventoryBO;

public interface BookInventoryRepository extends JpaRepository<BookInventoryBO, Serializable>{
	List<BookInventoryBO> findBybook(BookBO book);
}
