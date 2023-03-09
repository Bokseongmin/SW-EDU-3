package org.comstudy.boardWeb.persistence;

import org.comstudy.boardWeb.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, String> {

}
