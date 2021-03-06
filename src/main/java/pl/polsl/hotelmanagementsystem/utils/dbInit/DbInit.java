package pl.polsl.hotelmanagementsystem.utils.dbInit;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.polsl.hotelmanagementsystem.service.client.Client;
import pl.polsl.hotelmanagementsystem.service.client.ClientRepository;
import pl.polsl.hotelmanagementsystem.service.room.Room;
import pl.polsl.hotelmanagementsystem.service.room.RoomRepository;
import pl.polsl.hotelmanagementsystem.service.staff.Staff;
import pl.polsl.hotelmanagementsystem.service.staff.StaffRepository;
import pl.polsl.hotelmanagementsystem.service.user.Role;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Component
@AllArgsConstructor
public class DbInit {
    private final ClientRepository clientRepository;
    private final StaffRepository staffRepository;
    private final RoomRepository roomRepository;
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

    private void addRooms(Integer count){
        List<Room> rooms = new LinkedList<>();
        for(int i = 0; i < count; i++){
            Room room = Room.builder()
                    .id((long) i)
                    .number(i)
                    .size(i * 3)
                    .floor(i / 3)
                    .description(String.valueOf(i))
                    .price((double) i * 100)
                    .build();
            rooms.add(room);
        }
        roomRepository.saveAll(rooms);
    }
    //TODO: never, ever try leaving this function up for production
    @PostConstruct
    private void postConstruct(){
        if(clientRepository.findAll().isEmpty()){
            Client client = Client.builder()
                    .email("client")
                    .firstName("client")
                    .lastName("client_last_name")
                    .country("Poland")
                    .postCode("14-504")
                    .city("??ysina")
                    .address("Warszawa 12")
                    .phoneNumber("512-353-662")
                    .password(passwordEncoder.encode("string"))
                    .roles(new LinkedList<Role>(Collections.singletonList(Role.ROLE_CLIENT)))
                    .build();
            clientRepository.save(client);
        }

        if(staffRepository.findAll().isEmpty()){
            List<Staff> staffs = new LinkedList<>();
            staffs.add(staffCreator(Role.ROLE_ADMIN));
            staffs.add(staffCreator(Role.ROLE_KITCHEN));
            staffs.add(staffCreator(Role.ROLE_MANAGER));
            staffs.add(staffCreator(Role.ROLE_RECEPTION));
            staffs.add(staffCreator(Role.ROLE_ROOM_SERVICE));
            staffs.add(staffCreator(Role.ROLE_STAFF));
            staffRepository.saveAll(staffs);
        }

        if(roomRepository.findAll().isEmpty()){
            addRooms(5);
        }

        System.out.println("Database initialized with test users");
    }
}
