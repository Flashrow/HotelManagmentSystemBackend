package pl.polsl.hotelmanagementsystem.service.user;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.polsl.hotelmanagementsystem.controller.dto.LoginDTO;
import pl.polsl.hotelmanagementsystem.service.client.ClientRepository;
import pl.polsl.hotelmanagementsystem.service.staff.StaffRepository;
import pl.polsl.hotelmanagementsystem.utils.exception.ObjectExistsException;
import pl.polsl.hotelmanagementsystem.utils.security.jwt.JwtTokenProvider;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final StaffRepository staffRepository;
    private final ClientRepository clientRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public String login(LoginDTO loginDTO){
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
            String bearer;
            if (authentication.getAuthorities().contains(Role.ROLE_CLIENT)) {
                bearer = jwtTokenProvider.createToken(loginDTO.getEmail(), clientRepository.findByEmail(loginDTO.getEmail()).get().getRoles());
            } else if (authentication.getAuthorities().contains(Role.ROLE_STAFF)) {
                bearer = jwtTokenProvider.createToken(loginDTO.getEmail(), staffRepository.findByEmail(loginDTO.getEmail()).get().getRoles());
            } else throw new ObjectExistsException("User with given password does not exist");
            return "Bearer " + bearer;
        }
        catch (AuthenticationException authenticationException){
            throw new ObjectExistsException("Invalid username/password");
        }
    }
    public List<String> whatRolesAmI(){
        List<String> roles = SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return roles;
    }
}
