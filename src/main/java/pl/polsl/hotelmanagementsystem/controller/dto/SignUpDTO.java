package pl.polsl.hotelmanagementsystem.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpDTO {
    private final String name;
    private final String surname;
    private final String email;
    private final String repeatedEmail;
    private final String postCode;
    private final String password;
    private final String repeatedPassword;
    private final String number;
    private final String country;
    private final String city;
    private final String address;
}
