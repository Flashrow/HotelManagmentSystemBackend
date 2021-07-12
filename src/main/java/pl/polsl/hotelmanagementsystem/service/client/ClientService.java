package pl.polsl.hotelmanagementsystem.service.client;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import pl.polsl.hotelmanagementsystem.controller.dto.ClientDetailsDTO;
import pl.polsl.hotelmanagementsystem.controller.dto.SignUpDTO;
import pl.polsl.hotelmanagementsystem.service.user.Role;
import pl.polsl.hotelmanagementsystem.utils.exception.ObjectExistsException;
import pl.polsl.hotelmanagementsystem.utils.security.jwt.JwtTokenProvider;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {
    private final PasswordEncoder passwordEncoder;
    private final ClientRepository clientRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public String signUp(SignUpDTO signUpDTO){
        if(signUpDTO.getName() == null || signUpDTO.getSurname() == null || signUpDTO.getEmail() == null
        || signUpDTO.getRepeatedEmail() == null || signUpDTO.getPassword() == null || signUpDTO.getPostCode() == null
        || signUpDTO.getRepeatedPassword() == null || signUpDTO.getNumber() == null || signUpDTO.getCountry() == null
        || signUpDTO.getCity() == null || signUpDTO.getAddress() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fill all empty spaces");
        }
        if(!signUpDTO.getEmail().equals(signUpDTO.getRepeatedEmail()) ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Repeated email is not the same");
        }
        if(!signUpDTO.getPassword().equals(signUpDTO.getRepeatedPassword()) ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Repeated password blah blah");
        }

        if(clientRepository.findByEmail(signUpDTO.getEmail()).isPresent()){
            throw new ObjectExistsException("User with email " + signUpDTO.getEmail() + " exists!");
        }
        LinkedList<Role> roles = new LinkedList<>();
        roles.add(Role.ROLE_CLIENT);
        Client client = Client.builder()
                .email(signUpDTO.getEmail())
                .firstName(signUpDTO.getName())
                .lastName(signUpDTO.getSurname())
                .country(signUpDTO.getCountry())
                .postCode(signUpDTO.getPostCode())
                .city(signUpDTO.getCity())
                .address(signUpDTO.getAddress())
                .phoneNumber(signUpDTO.getNumber())
                .password(passwordEncoder.encode(signUpDTO.getPassword()))
                .roles(roles)
                .build();

        clientRepository.save(client);
        return "Bearer " + jwtTokenProvider.createToken(client.getEmail(), client.getRoles());
    }
    public ClientDetailsDTO getClientDetails(HttpServletRequest httpServletRequest){
         Client client = clientRepository.findByEmail(
                jwtTokenProvider.getUsername(
                        jwtTokenProvider.resolveToken(httpServletRequest)))
                 .orElseThrow(() -> new ObjectExistsException("There are no clients associated with this session"));
         return ClientDetailsDTO.builder()
                 .id(client.getId())
                 .name(client.getFirstName())
                 .surname(client.getLastName())
                 .email(client.getEmail())
                 .postCode(client.getPostCode())
                 .number(client.getPhoneNumber())
                 .country(client.getCountry())
                 .city(client.getCity())
                 .address(client.getAddress())
                 .build();
    }

    public Client getClientById(Long id){
        return clientRepository.findById(id).orElseThrow();
    }

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client whoami(){
        return search(SecurityContextHolder.getContext().getAuthentication().getName());
    }
    private Client search(String email){
        return clientRepository.findByEmail(email).orElseThrow(()
                -> new EntityNotFoundException("User with email" + email + "does not exist"));
    }

}
