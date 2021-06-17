package pl.polsl.hotelmanagementsystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.polsl.hotelmanagementsystem.controller.dto.LoginDTO;
import pl.polsl.hotelmanagementsystem.service.user.UserService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureJdbc
@AutoConfigureMockMvc
public class UserControllerTests {
    @Autowired
    private UserController userController;
    @Autowired
    private MockMvc mockMvc;
    private final String USERS = "/users";
    @MockBean
    private UserService userService;

    @Test
    public void contextLoads() throws Exception{
        assertThat(userController).isNotNull();
    }

    @Test
    public void shouldNotLoginBadMethod() throws Exception{
        LoginDTO loginDTO = new LoginDTO("client", "string");
        ObjectMapper objectMapper = new ObjectMapper();
        String loginJson = objectMapper.writeValueAsString(loginDTO);
        mockMvc.perform(get(USERS + "/login").contentType(MediaType.APPLICATION_JSON).content(loginJson))
                .andDo(print()).andExpect(status().isMethodNotAllowed());
    }

}
