package pl.polsl.hotelmanagementsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.polsl.hotelmanagementsystem.controller.dto.BlackoutTimeDTO;
import pl.polsl.hotelmanagementsystem.controller.dto.NewRoomDTO;
import pl.polsl.hotelmanagementsystem.service.checkedIn.CheckedInService;
import pl.polsl.hotelmanagementsystem.service.reservation.ReservationService;
import pl.polsl.hotelmanagementsystem.service.room.Room;
import pl.polsl.hotelmanagementsystem.service.room.RoomService;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/rooms")
public class RoomController {
    private final RoomService roomService;
    private final ReservationService reservationService;
    private final CheckedInService checkedInService;
    @PostMapping(path = "/addRoom")
    public void addRoom(@RequestBody NewRoomDTO newRoomDTO){
        roomService.addRoom(newRoomDTO);
    }
    @GetMapping(path = "/getAllRooms")
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }
    @GetMapping(path = "/{room_id}/blackoutDays")
    public List<BlackoutTimeDTO> getRoomBlackoutDays(@PathVariable("room_id") Long roomId){
        return reservationService.getBlackoutDays(roomId);
    }
    // TODO - only for logged users, might relocate
    @PostMapping(path = "/addReview")
    public void addReview(Long checkedInId, Date date, String content){
        checkedInService.addReview(checkedInId, date, content);
    }
}
