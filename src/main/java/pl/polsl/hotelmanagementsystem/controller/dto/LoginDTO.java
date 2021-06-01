package pl.polsl.hotelmanagementsystem.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginDTO {
    private final String email;
    private final String password;
}
