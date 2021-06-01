package pl.polsl.hotelmanagementsystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import pl.polsl.hotelmanagementsystem.controller.dto.NewRoomDTO;
import pl.polsl.hotelmanagementsystem.service.room.RoomService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureJdbc
@AutoConfigureMockMvc
public class RoomControllerTests {

    @Autowired
    private RoomController roomController;
    @Autowired
    private MockMvc mockMvc;
    private final String ROOMS = "/rooms";
    @MockBean
    private RoomService roomService;
    @Test
    public void contextLoads() throws Exception{
        assertThat(roomController).isNotNull();
    }


    @Test
    @WithMockUser(username = "username", roles = {"ADMIN"})
    public void shouldAddRoom() throws Exception{
        NewRoomDTO newRoomDTO = new NewRoomDTO(0L, 1, 1, 1, "test", 10d);
        ObjectMapper objectMapper = new ObjectMapper();
        String roomJSON = objectMapper.writeValueAsString(newRoomDTO);
        mockMvc.perform(post(ROOMS + "/addRoom").contentType("application/json").content(roomJSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "username", roles = {"CLIENT"})
    public void shouldNotAddRoom() throws Exception{
        mockMvc.perform(post(ROOMS + "/addRoom")).andDo(print()).andExpect(status().isForbidden());
    }

}
