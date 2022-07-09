package pjh.cqrspattern.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pjh.cqrspattern.dto.CreateMemberRequest;
import pjh.cqrspattern.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void signUp(CreateMemberRequest request){
        memberRepository.save(request.toEntity());
    }
}
