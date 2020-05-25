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

import groovy.util.logging.Slf4j;
import jline.internal.Log;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

@Controller
@Slf4j //디버깅 용도
public class boardController {
	@Autowired
	boardService boardService;
	@Autowired
	boardDAOImp boardDao;
	
	@RequestMapping("/board/write")
	public String boardWrite() {
		return "write";
	}
	
	@GetMapping("/board/insert")
	public String boardInsert(boardDTO boardDTO) {
	  boardDao.dbInsert(boardDTO); 
	  //return "redirect:/board/list";
	  return "redirect:/board/insertAlert";
	}//end
	
	@RequestMapping("/board/insertAlert")
	public String insertAlert() {
		StringBuilder sb =new StringBuilder();
		
		sb.append("<script>");
		sb.append("alert('게시물이 등록되었습니다.')");
		sb.append("</script>");
		sb.toString();
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/board/list")
	public String showList(Model model, boardDTO boardDTO, Pageable pageable, HttpServletRequest request) {
		int Gtotal = boardDao.dbCount();
		int start,end, startpage, endpage, temp, pagecount;
		
		String pnum = request.getParameter("pageNum");
		String sval = request.getParameter("keyword");
		String skey = request.getParameter("keyfield");
		String returnpage = "&keyfield="+skey+"&keyword"+sval;
		
		if(pnum == null || pnum.equals("") || pnum =="") {pnum ="1";}
		int pageNUM = Integer.parseInt(pnum);
		paging paging = new paging();
		paging.setPageNUM(pageNUM);
			
		if(Gtotal%10 == 0) {pagecount = Gtotal/10;}
		else {pagecount = (Gtotal/10)+1;}
		
		start = (pageNUM-1)*10;
		
		temp = (pageNUM-1)%10;
		startpage = pageNUM-temp;
		endpage = startpage+9;
		if(endpage>pagecount) {endpage=pagecount;}
		
		List<boardDTO> list = boardDao.dbSelect(paging, sval, skey);
		
		
		model.addAttribute("list", list);
		model.addAttribute("total", Gtotal);
		model.addAttribute("startpage", startpage);
		model.addAttribute("endpage", endpage);
		model.addAttribute("pageNUM", pageNUM);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("size", list.size()); //행번호 출력용
		model.addAttribute("returnpage", returnpage);
		model.addAttribute("start", start);
		
		return "list";
	}
	
	@RequestMapping("/board/detail")
	public String detail(boardDTO boardDTO, Model model) {
		boardDTO dto =boardDao.dbDetail(boardDTO);
		
		model.addAttribute("dto", dto);
		return "detail";
	}
	
	@RequestMapping("/board/delete")
	public String delete(boardDTO boardDTO) {
		boardDao.dbDelete(boardDTO);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/board/preedit")
	public String preedit(boardDTO boardDTO, Model model) {
		boardDTO dto =boardDao.dbDetail(boardDTO);
		model.addAttribute("dto", dto);
		return "edit";
	}
	
	@RequestMapping("/board/edit")
	public String edit(boardDTO boardDTO) {
		boardDTO dto = boardDao.dbEdit(boardDTO);
		return "redirect:/board/detail?seq="+dto.getSeq();
	}
}
