package pjh.cqrspattern.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pjh.cqrspattern.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,String> {
}
