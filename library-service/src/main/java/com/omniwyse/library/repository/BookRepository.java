package com.omniwyse.library.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.omniwyse.library.bo.BookBO;

public interface BookRepository extends JpaRepository<BookBO, Serializable>{
	BookBO findByTitle(String bookName);
	BookBO findByIsbnCode(String isbnCode);
	
	@Query("select distinct b from BookInventoryBO bi inner join bi.book b inner join bi.library li where (b.author like %:criteria% or b.title like %:criteria%) and li.id = :libraryId")
	List<BookBO> findBookByAuthorOrBookName(@Param("criteria")String criteria,@Param("libraryId") Long libraryId);
}
