package com.example.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.board.boardRepository;
import com.example.board.dto.boardDTO;

@Mapper //boardDAO가 대신 구현해줌
public interface boardDAO {

	public List<boardDTO> getList();
	
}
