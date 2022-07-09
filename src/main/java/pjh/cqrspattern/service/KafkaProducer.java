package pjh.cqrspattern.service;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class KafkaProducer {
    private static final String TOPIC="test";

    private final KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message) throws ExecutionException, InterruptedException {
        RecordMetadata recordMetadata = this.kafkaTemplate.send(TOPIC, message).get().getRecordMetadata();
        System.out.println("metaData: "+recordMetadata.offset());
    }
}
