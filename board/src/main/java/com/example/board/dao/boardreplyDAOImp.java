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
import com.example.board.boardreplyRepository;
import com.example.board.dao.boardDAO;
import com.example.board.dto.boardDTO;
import com.example.board.dto.paging;
import com.example.board.dto.boardreplyDTO;

@Service
@Component 
public class boardreplyDAOImp implements boardreplyDAO {
	@Autowired
	private boardreplyRepository temp;
	@Autowired
	private boardRepository btemp;
	@Autowired
	boardreplyDAO boardreplyDao;
	
	//상속시 필요
	public List<boardreplyDTO> getList(){	
		return boardreplyDao.getList();
			
	}
	
	//댓글 저장
	public void dbInsert(boardreplyDTO board) {
		temp.save(board);
	}
	
	//댓글 페이징 출력
	public List<boardreplyDTO> dbSelect(paging paging, boardreplyDTO dto) {
		Pageable pageable = PageRequest.of(paging.getPageNUM()-1, 3, Sort.by("rseq").descending());
		//PageRequest.of(page, size, sort)
		//Page<boardreplyDTO> all = temp.findAll(pageable);
		List<boardreplyDTO> list = new ArrayList<boardreplyDTO>();
		list = temp.findBySeq(dto.getSeq(), pageable);
		  
		return list;
	}//end
	
	//댓글 갯수 출력
	public int dbRcnt(int re_seq) {
		
		return btemp.rcnt(re_seq);
	}
	
	
	//댓글 한 건 삭제
	public void dbDelete(boardreplyDTO dto) {
		temp.delete(dto);
	}
	
	//댓글 수정
	public boardreplyDTO dbEdit(boardreplyDTO dto) {
		return temp.save(dto);
	}

	
}
