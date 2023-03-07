package org.comstudy.saramjpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="SARAM")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaramEntity {
   // @Id 는 무조건 넣어줘야 한다. (Primary key)
   @Id
   // 무조건 오토?
   @GeneratedValue (strategy = GenerationType.SEQUENCE)
     // auto 가 디폴트 값. 다이렉트를 지정되어있는 기준으로 설정 (persistence 에 있는 데이터베이스 정보)
   private Long seq;
   private String id;
   private String name;
   private int age;
}