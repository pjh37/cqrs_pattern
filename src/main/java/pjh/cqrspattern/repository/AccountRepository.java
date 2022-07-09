package pjh.cqrspattern.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pjh.cqrspattern.domain.Account;

public interface AccountRepository extends JpaRepository<Account,String> {
}
