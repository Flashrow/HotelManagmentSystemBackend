package pl.polsl.hotelmanagementsystem.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.polsl.hotelmanagementsystem.service.user.Role;

@Getter
@AllArgsConstructor
public class TESTSignUpDTO {
    private final String name;
    private final String surname;
    private final String email;
    private final String password;
    private final Role role;
}
