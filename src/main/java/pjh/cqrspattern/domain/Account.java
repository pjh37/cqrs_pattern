package pjh.cqrspattern.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity(name="account")
@NoArgsConstructor
@Getter
public class Account {
    @Id
    @Column(name = "account_id")
    private String id;

    private String userName;

    @OneToMany(mappedBy = "account")
    private Set<Reservation> reservationSet=new HashSet<>();

    public Account(String userId) {
        this.id = userId;
    }
}
