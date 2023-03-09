package org.comstudy.todo.repository;

import org.comstudy.todo.domain.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, String> {

}
