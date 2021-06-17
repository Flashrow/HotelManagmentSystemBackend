package pl.polsl.hotelmanagementsystem.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import pl.polsl.hotelmanagementsystem.controller.dto.LoginDTO;
import pl.polsl.hotelmanagementsystem.service.client.ClientRepository;
import pl.polsl.hotelmanagementsystem.service.staff.StaffRepository;
import pl.polsl.hotelmanagementsystem.service.user.UserService;
import pl.polsl.hotelmanagementsystem.utils.exception.ObjectExistsException;
import pl.polsl.hotelmanagementsystem.utils.security.jwt.JwtTokenProvider;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {
    @Mock
    private ClientRepository clientRepository;
    @Mock
    private StaffRepository staffRepository;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldNotLoginDoesNotExist() throws Exception{
        LoginDTO loginDTO = new LoginDTO("bad", "veryBad");
        Authentication authentication = Mockito.mock(Authentication.class);
        Mockito.when(authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword())))
                .thenReturn(authentication);
        Exception exception = assertThrows(ObjectExistsException.class, () -> {
            userService.login(loginDTO);
        });
        assertTrue(exception.getMessage() ,exception.getMessage().contains("User with given login does not exist"));

    }

    @Test
    void shouldNotLoginInvalidUser(){
        LoginDTO loginDTO = new LoginDTO("Ido", "exist_but_wrong_password");
        Authentication authentication = Mockito.mock(Authentication.class);
        Mockito.when(authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword())))
                .thenThrow(new ObjectExistsException("Invalid username/password"));
        Exception exception = assertThrows(ObjectExistsException.class, () -> {
            userService.login(loginDTO);
        });
        assertTrue("\nExpected: " + "Invalid username/password" +
                            "\nReceived: " + exception.getMessage(), exception.getMessage().contains("Invalid username/password"));
    }
}
