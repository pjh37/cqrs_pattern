package pjh.cqrspattern.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "room")
@NoArgsConstructor
@Getter
public class Room {
    @Id
    @Column(name = "room_id")
    private String id;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    @OneToMany(mappedBy = "room")
    private Set<Reservation> reservationSet=new HashSet<>();

    public Room(String roomId) {
        this.id = roomId;
    }
}
