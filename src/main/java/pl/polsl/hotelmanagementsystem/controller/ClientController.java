package pl.polsl.hotelmanagementsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.hotelmanagementsystem.controller.dto.ClientDetailsDTO;
import pl.polsl.hotelmanagementsystem.controller.dto.SignUpDTO;
import pl.polsl.hotelmanagementsystem.service.client.ClientService;

import javax.servlet.http.HttpServletRequest;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/clients")
public class ClientController {
    private final ClientService clientService;

    @PostMapping(path = "/signup")
    public String signUp(@RequestBody SignUpDTO signUpDTO){
        return clientService.signUp(signUpDTO); // only clients can register
    }

    @PostMapping(path = "/getMyDetails")
    public ClientDetailsDTO getMyDetails(HttpServletRequest request){
        return clientService.getClientDetails(request);
    }


}
