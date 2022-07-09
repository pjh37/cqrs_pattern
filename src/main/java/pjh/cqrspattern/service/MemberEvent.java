package pjh.cqrspattern.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pjh.cqrspattern.dto.event.CreateMemberEvent;

@Component
public class MemberEvent {

    //dbserver1.testdb.member
    @KafkaListener(topics = "dbserver1.testdb.member")
    public void consume(String message) throws JsonProcessingException {
        CreateMemberEvent mapper=new ObjectMapper()
                .readerFor(CreateMemberEvent.class)
                .readValue(message);
        System.out.printf("consumed message after %s%n",mapper.toString());

    }

    @KafkaListener(topics = "test")
    public void consumeTest(String message){
        System.out.printf("consumed message %s%n",message);
    }
}
