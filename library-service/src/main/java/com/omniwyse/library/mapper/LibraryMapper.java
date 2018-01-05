package com.omniwyse.library.mapper;

import com.omniwyse.library.bo.LibraryBO;
import com.omniwyse.library.dto.LibraryDto;

public class LibraryMapper {
	public LibraryDto convert(LibraryBO bo) {
		LibraryDto dto = new LibraryDto();
		//dto.setAddress(bo.getAddress());
		dto.setEstDate(bo.getEstDate());
		return dto;
	}
}
