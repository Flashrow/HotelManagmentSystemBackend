package pl.polsl.hotelmanagementsystem.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ClientDetailsDTO {
    private final String name;
    private final String surname;
    private final String email;
    private final String postCode;
    private final String number;
    private final String country;
    private final String city;
    private final String address;
}
