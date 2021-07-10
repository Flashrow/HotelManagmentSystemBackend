package pl.polsl.hotelmanagementsystem.service.client;

import lombok.*;
import pl.polsl.hotelmanagementsystem.service.roomIssue.RoomIssue;
import pl.polsl.hotelmanagementsystem.service.user.Role;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientInformationDTO {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String country;
    private String postCode;
    private String city;
    private String address;
    private String phoneNumber;
    private List<RoomIssue> roomIssues;
    private List<Role> roles;
}
