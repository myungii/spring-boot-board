package com.example.board.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.board.boardRepository;
import com.example.board.dao.boardDAO;
import com.example.board.dao.boardDAOImp;
import com.example.board.dto.boardDTO;
import com.example.board.dto.paging;
import com.example.board.service.boardService;
import com.example.board.dao.boardreplyDAO;
import com.example.board.dao.boardreplyDAOImp;
import com.example.board.dto.boardreplyDTO;

import groovy.util.logging.Slf4j;
import jline.internal.Log;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

@Controller
@Slf4j //디버깅 용도
public class boardreplyController {
	@Autowired
	boardreplyDAOImp dao;
	
	@RequestMapping("/reply/reply")
	public String boardWrite() {
		return "reply";
	}
	
	@GetMapping("/boardreply/insert")
	public String boardInsert(boardreplyDTO boardreplyDTO) {
	  dao.dbInsert(boardreplyDTO); 
	  return "redirect:/board/detail?seq="+boardreplyDTO.getSeq();
	 // return "reply";
	}//end
	
	@GetMapping("/reply/list")
	public String showList(Model model, boardreplyDTO boardreplyDTO, Pageable pageable, HttpServletRequest request) {
		int start,end, startpage, endpage, temp, pagecount;
		//int total = dao.dbCount(boardreplyDTO);
		String pnum = request.getParameter("pageNum");
		
		if(pnum == null || pnum.equals("") || pnum =="") {pnum ="1";}
		int pageNUM = Integer.parseInt(pnum);
		paging paging = new paging();
		paging.setPageNUM(pageNUM);
	
	
		start = (pageNUM-1)*10;
		paging.setStart(start);
		
		startpage = pageNUM-1;
		endpage = startpage+1;
		
		List<boardreplyDTO> list = dao.dbSelect(paging, boardreplyDTO);
		pagecount=list.size();
		System.out.println("pagecount : "+pagecount+" endpage : "+endpage);
		if(endpage>pagecount) {endpage = pagecount;}
		
		
		model.addAttribute("list", list);
		model.addAttribute("startpage", startpage);
		model.addAttribute("endpage", endpage);
		model.addAttribute("pageNUM", pageNUM);
		//model.addAttribute("total", total);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("start", start);
		return "reply";
	}
	
	
	@RequestMapping("/reply/delete")
	public String delete(boardreplyDTO boardreplyDTO) {
		dao.dbDelete(boardreplyDTO);
		return "redirect:/board/detail?seq="+boardreplyDTO.getSeq();
	}
	
	
	
	@RequestMapping("/reply/edit")
	public String edit(boardreplyDTO boardreplyDTO) {
		dao.dbEdit(boardreplyDTO);
		return "redirect:/board/detail?seq="+boardreplyDTO.getSeq();
	}
}
