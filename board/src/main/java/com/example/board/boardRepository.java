package com.example.board;

import org.springframework.data.repository.CrudRepository;

import com.example.board.dto.boardDTO;

public interface boardRepository extends CrudRepository<boardDTO, Integer> {

}
