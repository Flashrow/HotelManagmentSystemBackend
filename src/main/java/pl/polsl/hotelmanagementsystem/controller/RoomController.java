package pl.polsl.hotelmanagementsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.polsl.hotelmanagementsystem.controller.dto.NewRoomDTO;
import pl.polsl.hotelmanagementsystem.service.room.Room;
import pl.polsl.hotelmanagementsystem.service.room.RoomService;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/rooms")
public class RoomController {
    private final RoomService roomService;

    @PostMapping(path = "/addRoom")
    public void addRoom(@RequestBody NewRoomDTO newRoomDTO){
        roomService.addRoom(newRoomDTO);
    }
    @GetMapping(path = "/getAllRooms")
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }
    @GetMapping(path = "/{id}/blackoutDays")
    public List<Date> getRoomBlackoutDays(@PathVariable("id") Long id){
        //TODO
        return new LinkedList<>();
    }
}
