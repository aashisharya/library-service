package com.omniwyse.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omniwyse.library.bo.DeliveryTypeBO;

public interface DeliveryTypeRepository extends JpaRepository<DeliveryTypeBO, Long>{
	DeliveryTypeBO findByType(String type);
}
