package org.comstudy.todo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "TODO")
public class TodoEntity {
   @Id
   @GeneratedValue
   private String id; // 오브젝트 아이디
   private String userId;
   private String title;
   private boolean done;
}