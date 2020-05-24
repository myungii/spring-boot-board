package com.example.board.dao;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.apache.ibatis.annotations.Results;
import org.omg.CORBA.portable.ValueOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.board.boardRepository;
import com.example.board.dto.boardDTO;
import com.example.board.dto.paging;

@Service
@Component //Autowired에 의한 연결적용
public class boardDAOImp implements boardDAO {
	@Autowired
	private boardRepository temp;
	@Autowired
	boardDAO boardDao;
	
	//상속시 필요
	public List<boardDTO> getList(){
		return boardDao.getList();
		
	}

	//글쓰기 저장
	public void dbInsert(boardDTO board) {
		temp.save(board);
	}
	
	//게시판 리스트 페이징 출력
	public List<boardDTO> dbSelect(paging paging, String sval) {
		Pageable pageable = PageRequest.of(paging.getPageNUM()-1, 10, Sort.by("seq").descending());
		//PageRequest.of(page, size, sort)
		//Page<boardDTO> all = temp.findAll(pageable);
		if(sval == null || sval == "") {sval ="";}
		List<boardDTO> list = temp.findByTitleContaining(sval, pageable);
		  
		//return all.getContent();
		return list;
	}//end
	
	
	//게시물 총 갯수의 메소드
	public int dbCount() {
		  return (int)temp.count();
	}//end
	
	//상세보기 (한 건 출력)
	public boardDTO dbDetail(int seq) {
		boardDTO dto = new boardDTO(); 
		
		//temp.findAllById(seq);
		 return dto;
	}
	
	//게시물 한 건 삭제
	public void dbDelete(boardDTO dto) {
		temp.delete(dto);
	}
	
	//게시물 수정
	public boardDTO dbEdit(boardDTO dto) {
		return temp.save(dto);
	}
	
}
