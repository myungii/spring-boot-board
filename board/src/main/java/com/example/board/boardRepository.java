package com.example.board;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.board.dto.boardDTO;

public interface boardRepository extends JpaRepository<boardDTO, Integer> {//pk int형
	
	List<boardDTO> findByTitleContaining(String sval, Pageable pageable);
	
	
	 /* @Query(value = "select iu from UrnMapping iu where iu.urn like %:text% or iu.contact like %:text%")
	    Page<UrnMapping> fullTextSearch(@Param("text") String text, Pageable pageable);
	}
	*/
}
