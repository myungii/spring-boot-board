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
import com.example.board.dto.boardreplyDTO;

public interface boardreplyRepository extends JpaRepository<boardreplyDTO, Integer> {//pk int형
	
	List<boardreplyDTO> findBySeq(int seq, Pageable pageable);
	boardreplyDTO findBySeq(int seq);

}
