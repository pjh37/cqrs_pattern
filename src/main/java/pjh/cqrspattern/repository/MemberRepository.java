package pjh.cqrspattern.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pjh.cqrspattern.domain.Member;

public interface MemberRepository extends JpaRepository<Member,String> {
}
