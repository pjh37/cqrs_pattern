package pjh.cqrspattern.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import pjh.cqrspattern.domain.Reservation;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class CreateReservationRequest {
    private String userId;
    private String roomId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime from;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime to;

    public Reservation toEntity(){
        return Reservation.builder()
                .reservationId(UUID.randomUUID().toString())
                .from(this.from)
                .to(this.to)
                .build();
    }
}
