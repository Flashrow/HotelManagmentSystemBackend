package pl.polsl.hotelmanagementsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.polsl.hotelmanagementsystem.controller.dto.AddReservationDTO;
import pl.polsl.hotelmanagementsystem.service.reservation.Reservation;
import pl.polsl.hotelmanagementsystem.service.reservation.ReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/reservations")
public class ReservationController {
    private final ReservationService reservationService;
    @PostMapping(path = "/addReservation")
    public String addReservation(@RequestBody AddReservationDTO addReservationDTO){
        return reservationService.addReservation(addReservationDTO);
    }

    @GetMapping(path = "/getMyReservations")
    public String[] getMyReservations(){
        return reservationService.getClientReservations();
    }

    @PostMapping(path = "addFoodPreference")
    public String addFoodPreference(@RequestParam Long reservationId, @RequestParam String preference){
        return "TODO";
    }
}
