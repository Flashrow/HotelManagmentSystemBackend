package pl.polsl.hotelmanagementsystem.service.staff;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import pl.polsl.hotelmanagementsystem.service.user.Role;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    @JsonIgnore
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Role> roles;
}
