package pjh.cqrspattern.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pjh.cqrspattern.domain.Account;
import pjh.cqrspattern.domain.Reservation;
import pjh.cqrspattern.domain.Room;
import pjh.cqrspattern.dto.CreateReservationRequest;
import pjh.cqrspattern.repository.ReservationRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Transactional
    public void save(CreateReservationRequest createReservationRequest){
        Reservation reservation=createReservationRequest.toEntity();
        reservation.setAccount(new Account(createReservationRequest.getUserId()));
        reservation.setRoom(new Room(createReservationRequest.getRoomId()));
        reservationRepository.save(reservation);
    }
}
