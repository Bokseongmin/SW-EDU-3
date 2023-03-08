package org.comstudy.boardweb;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.comstudy.boardweb.domain.BoardEntity;

public class JPAClient {
	
	public static void main(String[] args) {
		insert();
		
		// insert() 실해 후 persistence.xml에 update로 수정 후 실행 
		// select();
	}

	public static void insert() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BoardWeb");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			BoardEntity board = new BoardEntity();
			board.setTitle("JPA 제목 SEQUENCE 적용");
			board.setWriter("김범준");
			board.setContent("SEQUENCE가 적용 된 JPA 글 등록 테스트 내용");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			em.persist(board);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
	
	public static void select() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BoardWeb");
		EntityManager em = emf.createEntityManager();
		try {
			BoardEntity board = em.find(BoardEntity.class, 1L);
			System.out.println(board);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}