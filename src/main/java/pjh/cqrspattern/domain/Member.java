package pjh.cqrspattern.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Member {
    @Id
    private String accountId;

    private String roleId;

    private String userName;

    private String userDescription;

    private LocalDateTime updateDate;

    @Builder
    public Member(String accountId, String roleId, String userName, String userDescription, LocalDateTime updateDate) {
        this.accountId = accountId;
        this.roleId = roleId;
        this.userName = userName;
        this.userDescription = userDescription;
        this.updateDate = updateDate;
    }
}
