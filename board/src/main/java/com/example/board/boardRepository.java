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
import com.example.board.dto.paging;

public interface boardRepository extends JpaRepository<boardDTO, Integer> {//pk int형
	
	List<boardDTO> findByTitleContaining(String sval, Pageable pageable);
	List<boardDTO> findByUseridContaining(String sval, Pageable pageable);
	List<boardDTO> findByDetailContaining(String sval, Pageable pageable);
	boardDTO findBySeq(int seq);
	 
	 //조회수 업데이트
	 @Transactional
	 @Modifying
	 @Query(value = "UPDATE boardDTO set hit = ?1 + 1 where seq= ?2", 
	            nativeQuery = true)
	void updateHit(@Param("hit") int hit, @Param("seq") int seq);
	 
	 //게시판 리스트 제목 옆 댓글 갯수 출력
	 @Query(value = "select * from boardDTO", nativeQuery = true)
	 List<boardDTO> replySelect();
	 
	 @Query(value = "select count(*) from boardreplyDTO where seq = ?1", nativeQuery = true)
	 int rcnt(@Param("seq") int seq);
	 
	 //추천수 업데이트
	 @Query(value = "update boardDTO set recommend = recommend + 1 where seq = ?", nativeQuery = true)
	 void updateUp(@Param("seq") int seq);
	
}
