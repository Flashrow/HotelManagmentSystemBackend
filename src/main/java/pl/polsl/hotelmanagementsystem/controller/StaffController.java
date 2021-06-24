package pl.polsl.hotelmanagementsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.polsl.hotelmanagementsystem.controller.dto.AddReservationDTO;
import pl.polsl.hotelmanagementsystem.controller.dto.KitchenTimeOfDayEnum;
import pl.polsl.hotelmanagementsystem.service.checkedIn.CheckedInService;
import pl.polsl.hotelmanagementsystem.service.client.Client;
import pl.polsl.hotelmanagementsystem.service.client.ClientService;
import pl.polsl.hotelmanagementsystem.service.reservation.ReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/staff")
public class StaffController {
    private final ClientService clientService;
    private final ReservationService reservationService;
    private final CheckedInService checkedInService;
    @GetMapping(path = "/kitchen/getFoodPreferences/{time-of-day}")
    public void getFoodPreferences(@PathVariable("time-of-day") KitchenTimeOfDayEnum timeOfDay){
        //TODO - leave it to free workforce
    }

    @GetMapping(path = "/roomService/{room-id}/getRoomIssues")
    public void getRoomIssues(@PathVariable("room-id") Long roomId){
        //TODO - leave it to free workforce
    }
    @PostMapping(path = "/roomService/resolveIssue/{issue-id}")
    public void resolveRoomIssues(@PathVariable("issue-id") Long issueId){
        //TODO - leave it to free workforce
    }

    @PostMapping(path = "/reception/getAllClients")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @PostMapping(path = "/reception/acceptPayment")
    public void acceptPayment(Long reservationId){
        //TODO - no idea what this should do as of now
    }
    @PostMapping(path = "/reception/checkIn")
    public void checkIn(Long clientId, Long residenceId){
        checkedInService.checkIn(clientId, residenceId);
    }
    @PostMapping(path = "/reception/checkOut")
    public void checkOut(Long checkedInId){
        checkedInService.checkOut(checkedInId);
    }
    @PostMapping(path = "/reception/addResidence")
    public void addResidence(Long roomID){
        //TODO - leave it to free workforce
    }
    @PostMapping(path = "/reception/modifyClientReservation/{reservation-id}")
    public void modifyClientReservation(@PathVariable("reservation-id") Long reservationId, Long clientId, AddReservationDTO addReservationDTO){
        reservationService.modifyClientReservation(reservationId, clientId, addReservationDTO);
    }
    @GetMapping(path = "/manager/getExpenses")
    public void getExpenses(){
        //TODO
    }
    @GetMapping(path = "/manager/getHotelInformation")
    public String getHotelInformation(){
        return "Tak, to jest hotel"; //TODO ???
    }
    @GetMapping(path = "/manager/getHotelHistory")
    public void getHotelHistory(){
        //TODO ???
    }
}
