package org.comstudy.boardWeb.controller;

import java.util.Date;

import org.comstudy.boardWeb.entity.Board;
import org.comstudy.boardWeb.entity.Member;
import org.comstudy.boardWeb.persistence.BoardRepository;
import org.comstudy.boardWeb.persistence.MemberRepository;
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
		// 참조 엔티티가 영속성 영역에 먼저 들어가야 한다.
		Member member = new Member();
		member.setId("mem01");
		member.setName("범준샘");
		member.setPassword("12345");
		member.setRole("User");
		memberRepo.save(member);
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setMember(member);
			board.setTitle("범준샘이 등록한 게시글 제목" + i);
			board.setContent("범준샘이 등록한 게시글 내용" + i);
			board.setCreateDate(new Date());
			board.setCnt(0);
			boardRepo.save(board);
		}
		return "boardTest() - BoardController 호출";
	}
}
