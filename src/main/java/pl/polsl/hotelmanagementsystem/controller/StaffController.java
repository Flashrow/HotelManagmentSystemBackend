package pl.polsl.hotelmanagementsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.polsl.hotelmanagementsystem.controller.dto.*;
import pl.polsl.hotelmanagementsystem.service.checkedIn.CheckedInService;
import pl.polsl.hotelmanagementsystem.service.client.Client;
import pl.polsl.hotelmanagementsystem.service.client.ClientService;
import pl.polsl.hotelmanagementsystem.service.clientFoodPreference.ClientFoodPreferenceService;
import pl.polsl.hotelmanagementsystem.service.clientFoodPreference.ClientFoodPreferenceTimeOfDayType;
import pl.polsl.hotelmanagementsystem.service.expense.Expense;
import pl.polsl.hotelmanagementsystem.service.expense.ExpenseService;
import pl.polsl.hotelmanagementsystem.service.payment.PaymentService;
import pl.polsl.hotelmanagementsystem.service.reservation.ReservationService;
import pl.polsl.hotelmanagementsystem.service.room.RoomService;
import pl.polsl.hotelmanagementsystem.service.roomIssue.RoomIssue;
import pl.polsl.hotelmanagementsystem.service.staff.Staff;
import pl.polsl.hotelmanagementsystem.service.staff.StaffService;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
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
    private final ClientFoodPreferenceService clientFoodPreferenceService;
    private final RoomService roomService;
    private final PaymentService paymentService;
    @GetMapping(path = "/getMyDetails")
    public Staff getMyDetails(HttpServletRequest request){
        return staffService.whoami();
    }

    @GetMapping(path = "/kitchen/getFoodPreferences/{time-of-day}")
    public KitchenDishesDTO getFoodPreferences(@PathVariable("time-of-day") ClientFoodPreferenceTimeOfDayType timeOfDay){
        return clientFoodPreferenceService.getFoodPreferencesForKitchen(timeOfDay);
    }

    @GetMapping(path = "/roomService/getAllOngoingRoomIssues")
    public List<RoomIssue> getRoomIssues(){
        return roomService.getAllOngoingRoomIssues();
    }
    @PostMapping(path = "/roomService/startIssue/{issue-id}")
    public void startRoomIssue(@PathVariable("issue-id") Long issueId){
        roomService.startRoomIssue(issueId);
    }
    @PostMapping(path = "/roomService/resolveIssue/{issue-id}")
    public void resolveRoomIssues(@PathVariable("issue-id") Long issueId){
        roomService.resolveRoomIssues(issueId);
    }

    @PostMapping(path = "/reception/getAllClients")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }
    @GetMapping(path = "/reception/getClient")
    public Client getClient(Long clientId){
        return clientService.getClientById(clientId);
    }
    @PostMapping(path = "/reception/acceptPayment")
    public void acceptPayment(Long paymentId){
        paymentService.acceptPayment(paymentId);
    }
    @PostMapping(path = "/reception/checkIn")
    public void checkIn(Long clientId, Long residenceId){
        checkedInService.checkIn(clientId, residenceId);
    }
    @PostMapping(path = "/reception/checkOut")
    public void checkOut(Long checkedInId){
        checkedInService.checkOut(checkedInId);
    }

    @GetMapping(path = "/reception/getActiveRooms")
    public List<SingleActiveRoomDTO> getActiveRooms(){
        return roomService.getActiveRooms();
    }
    @PostMapping(path = "/reception/modifyClientReservation/{reservation-id}")
    public void modifyClientReservation(@PathVariable("reservation-id") Long reservationId, Long clientId, AddReservationDTO addReservationDTO){
        reservationService.modifyClientReservation(reservationId, clientId, addReservationDTO);
    }
    @GetMapping(path = "/getAllRoomsAllRoomIssues")
    public List<RoomIssue> getAllRoomsAllRoomIssues(){
        return new LinkedList<>();  //TODO
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
    @PostMapping(path = "/admin/modifyRoom")
    public void modifyRoom(NewRoomDTO newRoomDTO){
        roomService.modifyRoom(newRoomDTO);
    }
}
