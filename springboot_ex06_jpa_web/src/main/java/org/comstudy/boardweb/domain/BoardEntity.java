package org.comstudy.boardweb.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "BOARD")
@Data
@SequenceGenerator(name = "BOARD_SEQ_GENERATOR", sequenceName = "BOARD_SEQUENCE", initialValue = 1, allocationSize = 1)
public class BoardEntity {
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ_GENERATOR")
	private Long no = 0L;
	private String title;
	private String writer;
	private String content;
	private Date createDate = new Date();
	private Long cnt = 0L;
}