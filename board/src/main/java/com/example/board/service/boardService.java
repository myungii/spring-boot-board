package com.example.board.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.dto.boardDTO;

@Mapper
public interface boardService {
	public List<boardDTO> getList();
}
