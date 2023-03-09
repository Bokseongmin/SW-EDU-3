package org.comstudy.boardweb.controller;

import java.util.Date;

import org.comstudy.boardweb.entity.Board;
import org.comstudy.boardweb.entity.Member;
import org.comstudy.boardweb.persistence.BoardRepository;
import org.comstudy.boardweb.persistence.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
	@Autowired
	private BoardRepository boardRepo;
	@Autowired
	private MemberRepository memberRepo;

	@GetMapping("/board/test")
	public String boardTest() {
		Member member = new Member();
		member.setId("mem01");
		member.setPassword("member111");
		member.setName("범준샘");
		member.setRole("User");
		memberRepo.save(member);
		for(int i=1; i<=3; i++) {
			Board board = new Board();
			board.setMember(member);
			board.setTitle("범준쌤이 등록한 게시글 " + i);
			board.setContent("범준쌤이 등록한 게시글 내용 " + i);
			board.setCreateDate(new Date());
			board.setCnt(0);
			boardRepo.save(board);
		}
		
		return "boardTest():String - BoardController";
	}
}
