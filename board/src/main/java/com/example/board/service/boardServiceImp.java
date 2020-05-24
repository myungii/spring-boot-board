package com.example.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.board.dao.boardDAO;
import com.example.board.dto.boardDTO;

public class boardServiceImp implements boardService {
	@Autowired
	boardDAO boardDAO;
	
	public List<boardDTO> getList(){
		
		List<boardDTO> list = new ArrayList<>();
		
		return list;
	}
}
