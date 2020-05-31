package com.example.board.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class paging {
	private int pageNUM;
	private int start, end;
	private int startpage, endpage, temp, pagecount;
	private int Gtotal;
	private int rcnt;
	private int seq;
	
	
	private String skey;
	private String sval;
}
