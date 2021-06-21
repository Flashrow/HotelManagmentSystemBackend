package pl.polsl.hotelmanagementsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.polsl.hotelmanagementsystem.controller.dto.AddReservationDTO;
import pl.polsl.hotelmanagementsystem.controller.dto.KitchenTimeOfDayEnum;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/staff")
public class StaffController {

    @GetMapping(path = "/kitchen/getFoodPreferences/{time-of-day}")
    public void getFoodPreferences(@PathVariable("time-of-day") KitchenTimeOfDayEnum timeOfDay){
        //TODO
    }

    @GetMapping(path = "/roomService/{room-id}/getRoomIssues")
    public void getRoomIssues(@PathVariable("room-id") Long roomId){
        //TODO
    }
    @PostMapping(path = "/roomService/resolveIssue/{issue-id}")
    public void resolveRoomIssues(@PathVariable("issue-id") Long roomId){
        //TODO
    }

    @PostMapping(path = "/reception/getAllClients")
    public void getAllClients(){
        //TODO
    }

    @PostMapping(path = "/reception/acceptPayment")
    public void acceptPayment(Long reservationId){
        //TODO - no idea what this should do as of now
    }
    @PostMapping(path = "/reception/checkIn")
    public void checkIn(Long clientId, Long residenceId){
        //TODO
    }
    @PostMapping(path = "/reception/checkOut")
    public void checkOut(Long clientId, Long residenceId){
        //TODO
    }
    @PostMapping(path = "/reception/addResidence")
    public void addResidence(Long roomID){
        //TODO
    }
    @PostMapping(path = "/reception/modifyClientReservation/{reservation-id}")
    public void modifyClientReservation(@PathVariable("reservation-id") Long reservationId, Long clientId, AddReservationDTO addReservationDTO){
        //TODO
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
