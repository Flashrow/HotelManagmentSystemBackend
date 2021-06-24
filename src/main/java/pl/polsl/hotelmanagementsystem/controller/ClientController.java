package pl.polsl.hotelmanagementsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.polsl.hotelmanagementsystem.controller.dto.AddReservationDTO;
import pl.polsl.hotelmanagementsystem.controller.dto.AddRoomIssueDTO;
import pl.polsl.hotelmanagementsystem.controller.dto.ClientDetailsDTO;
import pl.polsl.hotelmanagementsystem.controller.dto.SignUpDTO;
import pl.polsl.hotelmanagementsystem.service.client.ClientService;
import pl.polsl.hotelmanagementsystem.service.reservation.ReservationService;
import pl.polsl.hotelmanagementsystem.service.room.RoomService;
import pl.polsl.hotelmanagementsystem.service.roomIssue.RoomIssue;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/clients")
public class ClientController {
    private final ClientService clientService;
    private final ReservationService reservationService;
    private final RoomService roomService;

    @PostMapping(path = "/signup")
    public String signUp(@RequestBody SignUpDTO signUpDTO){
        return clientService.signUp(signUpDTO); // only clients can register
    }

    @PostMapping(path = "/getMyDetails")
    public ClientDetailsDTO getMyDetails(HttpServletRequest request){
        return clientService.getClientDetails(request);
    }
    @PostMapping(path = "/modifyMyReservation/{reservation-id}")
    public void modifyMyReservation(@PathVariable("reservation-id") Long reservationId, AddReservationDTO addReservationDTO){
        reservationService.modifyMyReservation(reservationId, addReservationDTO);
    }
    @GetMapping(path = "/getMyHistory")
    public void getMyHistory(){
        //TODO - dont touch until everything else is done
    }
    @PostMapping(path = "/addRoomIssue")
    public void addMyRoomIssue(@RequestBody AddRoomIssueDTO addRoomIssueDTO){
        roomService.addMyRoomIssue(addRoomIssueDTO);
    }
    @GetMapping(path = "/getMyRoomIssues")
    public List<RoomIssue> getMyRoomIssues(){
        return roomService.getMyRoomIssues();
    }

}
