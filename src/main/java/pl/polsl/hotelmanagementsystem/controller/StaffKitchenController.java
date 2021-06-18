package pl.polsl.hotelmanagementsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/staff/kitchen")
public class StaffKitchenController {

    @PostMapping(path = "/getFoodPreferences")
    public void getFoodPreferences(){

    }
}
