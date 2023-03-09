package org.comstudy.boardweb.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Board {
	@Id
	@GeneratedValue
	private Integer seq;
	private String title;
	private String content;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createDate;
	private Integer cnt;
	
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID", nullable = false)
	private Member member;
}
