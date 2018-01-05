package com.omniwyse.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omniwyse.library.bo.CategoryBO;

public interface CategoryRepository extends JpaRepository<CategoryBO, Long> {

}
