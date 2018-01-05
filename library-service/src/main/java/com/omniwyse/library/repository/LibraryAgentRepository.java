package com.omniwyse.library.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omniwyse.library.bo.LibraryAgentBO;
import com.omniwyse.library.bo.LibraryBO;
import com.omniwyse.library.bo.UserBO;

public interface LibraryAgentRepository extends JpaRepository<LibraryAgentBO, Serializable>{
	List<LibraryAgentBO> findByLibrary(LibraryBO library);
	List<LibraryAgentBO> findByAdmin(UserBO admin);
}
