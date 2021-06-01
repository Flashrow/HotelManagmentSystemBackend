package pl.polsl.hotelmanagementsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.hotelmanagementsystem.controller.dto.AddReservationDTO;
import pl.polsl.hotelmanagementsystem.service.reservation.ReservationService;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/reservations")
public class ReservationController {
    private final ReservationService reservationService;
    @PostMapping(path = "/addReservation")
    public String addReservation(@RequestBody AddReservationDTO addReservationDTO){
        return reservationService.addReservation(addReservationDTO);
    }
}
