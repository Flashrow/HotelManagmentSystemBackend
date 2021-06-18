package pl.polsl.hotelmanagementsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
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

}
