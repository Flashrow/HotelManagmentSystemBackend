package pl.polsl.hotelmanagementsystem.service.user;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import pl.polsl.hotelmanagementsystem.controller.dto.LoginDTO;
import pl.polsl.hotelmanagementsystem.service.client.ClientRepository;
import pl.polsl.hotelmanagementsystem.service.staff.StaffRepository;
import pl.polsl.hotelmanagementsystem.utils.security.jwt.JwtTokenProvider;

@Service
@AllArgsConstructor
public class UserService {
    private final StaffRepository staffRepository;
    private final ClientRepository clientRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public String login(LoginDTO loginDTO){
        Authentication authentication =  authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
        String bearer;
        //TODO possible bugs if user doesnt exist!
        if(authentication.getAuthorities().contains(Role.ROLE_CLIENT)){
            bearer = jwtTokenProvider.createToken(loginDTO.getEmail(), clientRepository.findByEmail(loginDTO.getEmail()).get().getRoles());
        }
        else{
            bearer = jwtTokenProvider.createToken(loginDTO.getEmail(), staffRepository.findByEmail(loginDTO.getEmail()).get().getRoles());
        }
        return "Bearer " + bearer;
    }



//    public String TESTLogin(LoginDTO loginDTO){
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
//        return "Bearer " + jwtTokenProvider.createToken(loginDTO.getEmail(), staffRepository.findByEmail(loginDTO.getEmail()).get().getRoles());
//    }
//
//    private final PasswordEncoder passwordEncoder;
//    public String TESTRegister(TESTSignUpDTO testSignUpDTO){
//        LinkedList<Role> roles = new LinkedList<>();
//        roles.add(testSignUpDTO.getRole());
//        Staff staff = Staff.builder()
//                .firstName(testSignUpDTO.getName())
//                .lastName(testSignUpDTO.getSurname())
//                .email(testSignUpDTO.getEmail())
//                .password(passwordEncoder.encode(testSignUpDTO.getPassword()))
//                .roles(roles)
//                .build();
//
//        staffRepository.save(staff);
//        return "Zarejestrowany testowy uzytkownik";
//    }
}
