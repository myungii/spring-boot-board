package com.example.board.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@Entity
public class boardDTO  { 
	@Id //pk설정
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int seq;	
	@Column(name="userid")
	private String userid;
	@Column(name="name")
	private String name;
	
	@Column(name="title")
	private String title;
	@Column(name="detail")
	private String detail;
	@Column(name="hit",insertable = false, updatable = false, columnDefinition = "number default 0")
	private int hit;
	@Column(name="recommend",insertable = false, updatable = false, columnDefinition = "number default 0")
	private int recommend;
	@Column(name="wdate", insertable = false, updatable = false, columnDefinition = "date default sysdate")
	private Date wdate;
	
	
}