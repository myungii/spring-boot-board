package com.example.board.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.board.boardRepository;
import com.example.board.dto.boardDTO;

@Service
@Component //Autowired에 의한 연결적용
public class boardDAOImp implements boardDAO {
	@Autowired
	private boardRepository temp;
	@Autowired
	boardDAO boardDao;

	
	public void dbInsert(boardDTO board) {
		temp.save(board);
	}
	
	public List<boardDTO> dbSelect( boardDTO board) {
		   return (List<boardDTO>)temp.findAll();
		}//end
	
	public int dbCount() {
		  return (int)temp.count();
	}//end
	
	public List<boardDTO> getList(){
		return boardDao.getList();
		
	}
}
