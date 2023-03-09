package org.comstudy.todo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.comstudy.todo.domain.TodoEntity;
import org.comstudy.todo.dto.ResponseDTO;
import org.comstudy.todo.dto.TodoDTO;
import org.comstudy.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*") // React 프로젝트에서 포트번호가 다른 문제 해결
@RestController
@RequestMapping("/todo")
public class TodoController {
	@Autowired
	TodoService service;

	String tmpUserId = "temporary-user";
	// 입력
	// DTO가 Post로 들어오면 실행
	@PostMapping
	public ResponseEntity<?> createTodo(@RequestBody TodoDTO dto) {
		try {
			// 1. Entity로 변환
			TodoEntity entity = dto.toEntity();
			// 2. Entity의 id는 생성시 null이어야 한다. (영속성을 넘기기 전까지는 null이어야 한다. 테이블에 insert될 때 자동
			// 생성)
			entity.setId(null);
			// 3. 임시 UserId 사용
			entity.setUserId(tmpUserId);
			// 4. service를 이용해서 Entity 생성
			List<TodoEntity> entitis = service.create(entity);
			// 5. TodoEntity 리스트를 TodoDTO 리스트로 변환
			// :: 이중 콜론 연산자 람다 표현식
			// a ->
			// entitis.stream().map(a->a.new()).collect(Collectors.toList());
			List<TodoDTO> dtos = entitis.stream().map(TodoDTO::new).collect(Collectors.toList());
			// 6. TodoDTO 리스트를 ResponseDTO로 초기화
			// 생성할 때
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
			// 7. ResponseDTO를 리턴한다.
			return ResponseEntity.ok().body(response);

		} catch (Exception e) {
			// 예외 발생 시 처리
			String error = e.getMessage();
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
			return ResponseEntity.badRequest().body(response);
		}
	}

	// 검색
	@GetMapping
	public ResponseEntity<?> findTodoList(@RequestBody TodoDTO dto) {
		return null;
	}

	// 수정
	@PutMapping
	public ResponseEntity<?> updateTodo(@RequestBody TodoDTO dto) {
		// 1. dto로 변환
		TodoEntity entity = dto.toEntity();
		// 2. id 초기화
		entity.setUserId(tmpUserId);
		// 3. Entity 업데이트
		List<TodoEntity> entitis = service.update(entity);
		// 4. Entity 리스트를 Todo 리스트로 변환
		List<TodoDTO> todos = entitis.stream().map(TodoDTO::new).collect(Collectors.toList());
		// 5. ResponseDTO 초기화
		ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(todos).build();
		// ResponseDTO 리턴
		return ResponseEntity.ok().body(response);
	}

	// 삭제
	@DeleteMapping
	public ResponseEntity<?> deleteTodo(@RequestBody TodoDTO dto) {
		try {
			TodoEntity entity = dto.toEntity();
			// 2. id 초기화
			entity.setUserId(tmpUserId);
			// 3. entity로 업데이트
			List<TodoEntity> entitis = service.delete(entity);
			ResponseDTO<TodoEntity> response = ResponseDTO.<TodoEntity>builder().data(entitis).build();
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			ResponseDTO<TodoEntity> response = ResponseDTO.<TodoEntity>builder().error("삭제 에러!").build();
			return ResponseEntity.ok().body(response);
		}
	}

	@GetMapping("/list")
	public String selectList() {
		String userId = "";
		List<TodoEntity> todoList = service.findAll();
		System.out.print(">>>>>>>> todo list: ");
		for (TodoEntity todo : todoList) {
			System.out.println(todo);
		}
		return "todo list";
	}
}
