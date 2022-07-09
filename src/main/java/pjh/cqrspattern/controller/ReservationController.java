package pjh.cqrspattern.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pjh.cqrspattern.dto.CreateReservationRequest;
import pjh.cqrspattern.service.ReservationService;

@RestController
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping("/reservations")
    public String save(@RequestBody CreateReservationRequest createReservationRequest){
        reservationService.save(createReservationRequest);
        return "ok";
    }
}
