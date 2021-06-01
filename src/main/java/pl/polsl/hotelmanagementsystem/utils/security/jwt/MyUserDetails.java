package pl.polsl.hotelmanagementsystem.utils.security.jwt;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.polsl.hotelmanagementsystem.service.client.Client;
import pl.polsl.hotelmanagementsystem.service.client.ClientRepository;
import pl.polsl.hotelmanagementsystem.service.staff.Staff;
import pl.polsl.hotelmanagementsystem.service.staff.StaffRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MyUserDetails implements UserDetailsService {

    private final ClientRepository clientRepository;
    private final StaffRepository staffRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Hibernate.initialize();
        final Optional<Client> client = clientRepository.findByEmail(username);
        if (client.isPresent()) {

            return User.withUsername(username)
                    .password(client.get().getPassword())
                    .roles("CLIENT")
                    .authorities(client.get().getRoles())
                    .accountExpired(false)
                    .accountLocked(false)
                    .credentialsExpired(false)
                    .disabled(false)
                    .build();
        }
        else {
            final Optional<Staff> staff = staffRepository.findByEmail(username);
            if(staff.isPresent()){

                return User.withUsername(username)
                        .password(staff.get().getPassword())
                        .authorities(staff.get().getRoles())
                        .accountExpired(false)
                        .accountLocked(false)
                        .credentialsExpired(false)
                        .disabled(false)
                        .build();
            }

        }
        throw new UsernameNotFoundException("User '" + username + "' not found");
    }
}
