package pl.polsl.hotelmanagementsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.polsl.hotelmanagementsystem.controller.dto.AddReservationDTO;
import pl.polsl.hotelmanagementsystem.controller.dto.KitchenTimeOfDayEnum;
import pl.polsl.hotelmanagementsystem.service.checkedIn.CheckedInService;
import pl.polsl.hotelmanagementsystem.service.client.Client;
import pl.polsl.hotelmanagementsystem.service.client.ClientService;
import pl.polsl.hotelmanagementsystem.service.expense.Expense;
import pl.polsl.hotelmanagementsystem.service.expense.ExpenseService;
import pl.polsl.hotelmanagementsystem.service.reservation.ReservationService;
import pl.polsl.hotelmanagementsystem.service.staff.Staff;
import pl.polsl.hotelmanagementsystem.service.staff.StaffService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/staff")
public class StaffController {
    private final ClientService clientService;
    private final ReservationService reservationService;
    private final CheckedInService checkedInService;
    private final ExpenseService expenseService;
    private final StaffService staffService;
    @GetMapping(path = "/getMyDetails")
    public Staff getMyDetails(HttpServletRequest request){
        return staffService.whoami();
    }

    @GetMapping(path = "/kitchen/getFoodPreferences/{time-of-day}")
    public void getFoodPreferences(@PathVariable("time-of-day") KitchenTimeOfDayEnum timeOfDay){
        //TODO - leave it to free workforce
    }

    @GetMapping(path = "/roomService/{room-id}/getRoomIssues")
    public void getRoomIssues(@PathVariable("room-id") Long roomId){
        //TODO - leave it to free workforce - remember - show ONLY in_progress and reported.
    }
    @PostMapping(path = "/roomService/startIssue/{issue-id}")
    public void startRoomIssue(@PathVariable("issue-id") Long issueId){
        //TODO - leave it to free workforce - set the specified issue as in_progress
    }
    @PostMapping(path = "/roomService/resolveIssue/{issue-id}")
    public void resolveRoomIssues(@PathVariable("issue-id") Long issueId){
        //TODO - leave it to free workforce  - set the specified issue as resolved
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
    public List<Expense> getExpenses(){
        return expenseService.getExpenses();
        //TODO - and where do we incur expenses?
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
