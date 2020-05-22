package com.example.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.board.dao.boardDAO;
import com.example.board.dao.boardDAOImp;
import com.example.board.dto.boardDTO;
import com.example.board.service.boardService;

import groovy.util.logging.Slf4j;
import jline.internal.Log;

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
	
	@RequestMapping("/board/insert")
	public String boardInsert(boardDTO boardDTO) {
	  boardDao.dbInsert(boardDTO); 
	  return "redirect:/board/list";
	}//end
	
	@RequestMapping("/board/list")
	public String showList(Model model, boardDTO boardDTO) {
		int Gtotal = boardDao.dbCount();
		List<boardDTO> list = boardDao.dbSelect(boardDTO);
		
		int num = 1;
		for(int i=1; i<=Gtotal;i++) {
			num = i/num;
			System.out.println("숫자 : "+ num);
			
			boardDTO dto = new boardDTO();
			list.add(dto);
			 
			System.out.println("숫자 2: "+ list);
		}
		
		//List<boardDTO> list = boardService.getList();
		//Log.info("list : "+list);
		model.addAttribute("list", list);
		model.addAttribute("total", Gtotal);
		return "list";
	}
}
