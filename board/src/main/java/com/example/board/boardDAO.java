package com.example.board;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class boardDAO {
	@Autowired
	private boardRepository temp;
	
	public void insert(boardDTO board) {
		temp.save(board);
	}
}
