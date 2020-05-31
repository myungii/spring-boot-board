package com.example.board.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import groovy.transform.ToString;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@ToString
@Entity
public class recommendDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rec_seq")
	private int rec_seq;
	
	@Column(name="seq")
	private int seq;
	
	@Column(name="userid")
	private String userid;
	
	@Column(name="recommend")
	private int recommend;
	
}
