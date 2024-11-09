package com.kdigital.test3.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kdigital.test3.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
	// 3) 페이징 + 검색기능
	Page<BoardEntity> findByBoardTitleContains(String searchWord, PageRequest of);

	

	Page<BoardEntity> findByBoardWriterContains(String searchWord, PageRequest of);



	Page<BoardEntity> findByBoardContentContains(String searchWord, PageRequest of);
	
	
	
	
	
	
	
	
	
	
	
	
	// 검색기능을 수행하기 위해 만들어짐
	
//	List<BoardEntity> findByBoardWriterContains(String searchWord, Sort sort);
//
//	List<BoardEntity> findByBoardTitleContains(String searchWord, Sort sort);
//
//	List<BoardEntity> findByBoardContentContains(String searchWord, Sort sort);

}
