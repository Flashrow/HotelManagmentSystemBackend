package pl.polsl.hotelmanagementsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.polsl.hotelmanagementsystem.controller.dto.AddReservationDTO;
import pl.polsl.hotelmanagementsystem.service.clientFoodPreference.ClientFoodPreference;
import pl.polsl.hotelmanagementsystem.service.clientFoodPreference.ClientFoodPreferenceType;
import pl.polsl.hotelmanagementsystem.service.payment.Payment;
import pl.polsl.hotelmanagementsystem.service.reservation.Reservation;
import pl.polsl.hotelmanagementsystem.service.reservation.ReservationService;
import pl.polsl.hotelmanagementsystem.service.residence.Residence;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/reservations")
public class ReservationController {
    private final ReservationService reservationService;
    @PostMapping(path = "/addReservation")
    public Long addReservationAndReturnItsId(@RequestBody AddReservationDTO addReservationDTO){
        return reservationService.addReservation(addReservationDTO);
    }

    @GetMapping(path = "/getMyResidences")
    public List<Residence> getMyResidences(){
        return reservationService.getMyResidences();
    }

    @GetMapping(path = "/{reservation_id}/getReservation")
    public Reservation getReservation(@PathVariable("reservation_id") Long reservationId){
        return reservationService.getReservation(reservationId);
    }

    @PostMapping(path = "/addFoodPreference")
    public ClientFoodPreference addFoodPreference(@RequestParam Long reservationId,
                                                  @RequestParam ClientFoodPreferenceType clientFoodPreferenceType,
                                                  @RequestParam String preference){
        return reservationService.addClientFoodPreference(reservationId, clientFoodPreferenceType, preference);
    }

    @PostMapping(path = "/addPayment")
    public Payment addPayment(@RequestParam Long reservationId, @RequestParam Double amount){
        return reservationService.addPayment(reservationId, amount);
    }
}
