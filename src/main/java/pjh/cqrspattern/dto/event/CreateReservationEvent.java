package pjh.cqrspattern.dto.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Map;
import java.util.TimeZone;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class CreateReservationEvent {
    private String userId;

    private String roomId;

    private LocalDateTime from;

    private LocalDateTime to;


    @JsonProperty("payload")
    private void unpackNested(Map<String,Object> payload) {
        Map<String,Object> after = (Map<String,Object>)payload.get("after");
        this.userId=(String)after.get("account_id");
        this.roomId=(String)after.get("room_id");
        this.from=Instant.ofEpochMilli((long)after.get("start_time")).atZone(ZoneId.systemDefault()).toLocalDateTime();
        this.to=Instant.ofEpochMilli((long)after.get("end_time")).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    @Override
    public String toString() {
        return "CreateReservationEvent{" +
                "userId='" + userId + '\'' +
                ", roomId='" + roomId + '\'' +
                ", from=" + from.toString() +
                ", to=" + to.toString() +
                '}';
    }
}
