package pjh.cqrspattern.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pjh.cqrspattern.dto.event.CreateMemberEvent;
import pjh.cqrspattern.dto.event.CreateReservationEvent;

@Service
public class ReservationHistoryService {

    @KafkaListener(topics = "dbserver1.testdb.reservation")
    public void save(String message) throws JsonProcessingException {
        System.out.println("before parsing: "+message);
        CreateReservationEvent mapper=new ObjectMapper()
                .readerFor(CreateReservationEvent.class)
                .readValue(message);
        System.out.printf("consumed message after %s%n",mapper.toString());
    }
}
