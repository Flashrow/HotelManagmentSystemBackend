package pl.polsl.hotelmanagementsystem.utils.dbInit;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.polsl.hotelmanagementsystem.service.client.Client;
import pl.polsl.hotelmanagementsystem.service.client.ClientRepository;
import pl.polsl.hotelmanagementsystem.service.staff.Staff;
import pl.polsl.hotelmanagementsystem.service.staff.StaffRepository;
import pl.polsl.hotelmanagementsystem.service.user.Role;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Component
@AllArgsConstructor
public class DbInit {
    private final ClientRepository clientRepository;
    private final StaffRepository staffRepository;
    private final PasswordEncoder passwordEncoder;
    private List<Role> staffRoleListCreator(Role role){
        List<Role> roles = new LinkedList<>();
        roles.add(role);
        roles.add(Role.ROLE_STAFF);
        return roles;
    }
    private Staff staffCreator(Role role){
        return Staff.builder()
                .email(role.name())
                .firstName("Admin")
                .lastName("Staff surname")
                .password(passwordEncoder.encode("string"))
                .roles(staffRoleListCreator(role))
                .build();
    }

    @PostConstruct
    private void postConstruct(){
        Client client = Client.builder()
                .email("client")
                .firstName("client")
                .lastName("client_last_name")
                .country("Poland")
                .postCode("14-504")
                .city("łysina")
                .address("Warszawa 12")
                .phoneNumber("512-353-662")
                .password(passwordEncoder.encode("string"))
                .roles(staffRoleListCreator(Role.ROLE_CLIENT))
                .build();
        clientRepository.save(client);

        staffRepository.save(staffCreator(Role.ROLE_ADMIN));
        staffRepository.save(staffCreator(Role.ROLE_KITCHEN));
        staffRepository.save(staffCreator(Role.ROLE_MANAGER));
        staffRepository.save(staffCreator(Role.ROLE_RECEPTION));
        staffRepository.save(staffCreator(Role.ROLE_ROOM_SERVICE));
        staffRepository.save(staffCreator(Role.ROLE_STAFF));
        List<Staff> staff = staffRepository.findAll();
        System.out.println("Database initailized with test users");
    }
}
