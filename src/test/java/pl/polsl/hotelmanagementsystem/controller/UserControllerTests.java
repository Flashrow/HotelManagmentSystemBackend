package pl.polsl.hotelmanagementsystem.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.polsl.hotelmanagementsystem.service.user.UserService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureJdbc
@AutoConfigureMockMvc
public class UserControllerTests {
    @Autowired
    private UserController userController;

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @Test
    public void contextLoads() throws Exception{
        assertThat(userController).isNotNull();
    }

}
