package com.example.board.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.board.dto.boardDTO;
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
public class boardreplyDTO  { 
	@Id //pk설정
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rseq")
	private int rseq;	

	@Column(name="ruserid")
	private String ruserid;
	@Column(name="rdetail")
	private String rdetail;
	@Column(name="rwdate", insertable = false, updatable = false, columnDefinition = "date default sysdate")
	private Date rwdate;
	@Column(name="seq")
	private int seq;
	
	@ManyToOne
	private boardDTO boardDTO;
	 

}