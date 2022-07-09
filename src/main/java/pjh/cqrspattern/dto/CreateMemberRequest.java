package pjh.cqrspattern.dto;

import lombok.Getter;
import lombok.Setter;
import pjh.cqrspattern.domain.Member;

import java.util.UUID;

@Getter
@Setter
public class CreateMemberRequest {
    private String accountId;

    private String roleId;

    private String userName;

    private String userDescription;

    public Member toEntity(){
        return Member.builder()
                .accountId(UUID.randomUUID().toString())
                .roleId(this.roleId)
                .userName(this.userName)
                .userDescription(this.userDescription)
                .build();
    }
}
