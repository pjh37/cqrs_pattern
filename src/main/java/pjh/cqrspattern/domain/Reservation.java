package pjh.cqrspattern.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "reservation")
@NoArgsConstructor
@Setter
@Getter
public class Reservation {

    @Id
    private String reservationId;

    @ManyToOne(targetEntity = Account.class)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(targetEntity = Room.class)
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name = "start_time")
    private LocalDateTime from;

    @Column(name = "end_time")
    private LocalDateTime to;

    @Builder
    public Reservation(String reservationId, Account account, Room room, LocalDateTime from, LocalDateTime to) {
        this.reservationId = reservationId;
        this.account = account;
        this.room = room;
        this.from = from;
        this.to = to;
    }

    public void setAccount(Account account){
        this.account=account;
    }

    public void setRoom(Room room){
        this.room=room;
    }
}
