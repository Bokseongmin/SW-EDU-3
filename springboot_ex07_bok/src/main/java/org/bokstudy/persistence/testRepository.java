package org.bokstudy.persistence;

import org.bokstudy.test.Board;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface testRepository extends CrudRepository<Board, Integer>{

}
