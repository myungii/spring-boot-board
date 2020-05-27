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

import groovy.ui.text.FindReplaceUtility;

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
	public List<boardDTO> dbSelect(paging paging) {
		Pageable pageable = PageRequest.of(paging.getPageNUM()-1, 10, Sort.by("seq").descending());
		//PageRequest.of(page, size, sort)
		Page<boardDTO> all = temp.findAll(pageable);
		  
		return all.getContent();
	}//end
	
	public List<boardDTO> dbSelect(paging paging, String sval, String skey) {
		Pageable pageable = PageRequest.of(paging.getPageNUM()-1, 10, Sort.by("seq").descending());
		//PageRequest.of(page, size, sort)
		//Page<boardDTO> all = temp.findAll(pageable);
		List<boardDTO> list = new ArrayList<boardDTO> ();
		if(sval == null || sval == "") {sval = "";}
		if(skey == null || skey == "") {skey = "title";}
		System.out.println("검색 : "+sval+" "+skey+" paging : "+paging.getSval()+" "+paging.getSval());
		if(skey.equals("title")) {list = temp.findByTitleContaining(sval, pageable);}
		else if(skey.equals("userid")) {list = temp.findByUseridContaining(sval, pageable);}
		else {list = temp.findByDetailContaining(sval, pageable);}
		boardDTO boardDTO = new boardDTO();
		//return all.getContent();
		return list;
	}
	
	
	//게시물 총 갯수의 메소드
	public int dbCount() {
		  return (int)temp.count();
	}//end
	
	//상세보기 (한 건 출력)
	public boardDTO dbDetail(boardDTO dto) {
		//temp.save(dto);
		 return temp.findById(dto.getSeq()).get();
	}
	
	//게시물 조회수 업데이트
	public void dbHit(int hit) {
		temp.updateHit(hit);
	}
	
	//게시물 한 건 삭제
	public void dbDelete(boardDTO dto) {
		temp.delete(dto);
	}
	
	//게시물 수정
	public boardDTO dbEdit(boardDTO dto) {
		return temp.save(dto);
	}
	
	//댓글갯수 출력
	public int rcnt(List<boardDTO> board) {
		
		return 0;
	}
}
