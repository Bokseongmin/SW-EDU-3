package org.comstudy.boardWeb.persistence;

import org.comstudy.boardWeb.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String>{

}
