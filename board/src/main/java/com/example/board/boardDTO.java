package com.example.board;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class boardDTO  { 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int seq;
	
	private String userid;
	private String name;
	private String title;
	private String detail;
	@Column(name="hit",insertable = false, updatable = false, columnDefinition = "number default 0")
	private int hit;
	@Column(name="recommend",insertable = false, updatable = false, columnDefinition = "number default 0")
	private int recommend;
	@Column(name="wdate", insertable = false, updatable = false, columnDefinition = "date default sysdate")
	private Date wdate;
	
	
}