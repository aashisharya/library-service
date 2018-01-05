package com.omniwyse.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omniwyse.library.bo.ProfileTypeBO;

public interface ProfileTypeRepository extends JpaRepository<ProfileTypeBO, Long>{

}
