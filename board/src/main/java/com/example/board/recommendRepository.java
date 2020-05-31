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
import com.example.board.dto.recommendDTO;

public interface recommendRepository extends JpaRepository<recommendDTO, Integer> {//pk int형
	
	 //추천수 업데이트
	 @Query(value = "select count(*) from recommendDTO where seq = ?1 and userid = ?2", nativeQuery = true)
	 int recommend_cnt(@Param("seq") int seq, @Param("userid") String userid);
	 
	 @Query(value = "update recommendDTO set recommend = recommend + 1 where seq = ?1 and userid = ?2", nativeQuery = true)
	 void up(@Param("seq") int seq, @Param("userid") String userid);
}
