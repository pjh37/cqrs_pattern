package pjh.cqrspattern.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pjh.cqrspattern.dto.CreateMemberRequest;
import pjh.cqrspattern.service.KafkaProducer;
import pjh.cqrspattern.service.MemberService;

import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    private final KafkaProducer producer;

    @PostMapping("/members")
    public String signUp(@RequestBody CreateMemberRequest request){
        memberService.signUp(request);
        return "ok";
    }

    @GetMapping("/messages")
    public String produce(@RequestParam("message") String message) throws ExecutionException, InterruptedException {
        producer.sendMessage(message);
        return "ok";
    }
}
