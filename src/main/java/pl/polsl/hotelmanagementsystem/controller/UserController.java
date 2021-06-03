package pl.polsl.hotelmanagementsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.hotelmanagementsystem.controller.dto.LoginDTO;
import pl.polsl.hotelmanagementsystem.service.client.ClientService;
import pl.polsl.hotelmanagementsystem.service.user.UserService;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/users")
public class UserController {
    private final UserService userService;
    private final ClientService clientService;

    @PostMapping(path = "/login")
    public String login(@RequestBody LoginDTO loginDTO){
        return userService.login(loginDTO);     // everyone can login
    }


//    //TODO DELETE BEFORE PRODUCTION
//    @PostMapping(path = "/TESTLogin")
//    public String TESTLogin(@RequestBody LoginDTO loginDTO){
//        return userService.TESTLogin(loginDTO); // only staff can login
//    }
//    @PostMapping(path = "/TESTRegister")
//    public String TESTRegister(@RequestBody TESTSignUpDTO testSignUpDTO){
//        return userService.TESTRegister(testSignUpDTO); // only staff can register
//    }
}
