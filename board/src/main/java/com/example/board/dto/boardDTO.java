package com.example.board.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.board.dto.boardreplyDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@Column(name="seq")
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

	@OneToMany(mappedBy = "boardDTO" ,cascade = CascadeType.REMOVE)
	  private List<boardreplyDTO> boardreplyDTO = new ArrayList<>();

}