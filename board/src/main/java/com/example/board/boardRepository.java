package com.example.board;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.board.dto.boardDTO;
import com.example.board.dto.boardreplyDTO;

public interface boardRepository extends JpaRepository<boardDTO, Integer> {//pk int형
	
	List<boardDTO> findByTitleContaining(String sval, Pageable pageable);
	List<boardDTO> findByUseridContaining(String sval, Pageable pageable);
	List<boardDTO> findByDetailContaining(String sval, Pageable pageable);
	boardDTO findBySeq(int seq);
	 
	 //조회수 업데이트
	 @Transactional
	 @Modifying
	 @Query(value = "UPDATE boardDTO set hit = ?1 + 1", 
	            nativeQuery = true)
	void updateHit(@Param("hit") int hit);
	 
	 @Query(value = "select count(r.seq) as rcnt from boardreplyDTO r inner join boardDTO b" + 
		 		"  on r.seq = b.seq where r.seq = ?1", nativeQuery = true)
	 int rcnt(@Param("seq") int seq);
	 
	 
	 /* @Query(value = "select iu from UrnMapping iu where iu.urn like %:text% or iu.contact like %:text%")
	    Page<UrnMapping> fullTextSearch(@Param("text") String text, Pageable pageable);
	}
	*/
}
