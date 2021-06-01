package pl.polsl.hotelmanagementsystem.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.test.context.support.WithMockUser;
import pl.polsl.hotelmanagementsystem.controller.dto.NewRoomDTO;
import pl.polsl.hotelmanagementsystem.service.room.Room;
import pl.polsl.hotelmanagementsystem.service.room.RoomRepository;
import pl.polsl.hotelmanagementsystem.service.room.RoomService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class RoomServiceTests {

    @Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private RoomService roomService;

    @Test
    @WithMockUser(authorities = "CLIENT")
    //@WithMockUser(authorities = {"ROLE_ADMIN"}, roles = {"ROLE_ADMIN"})
    void shouldReturnAllRooms(){
        NewRoomDTO newRoomDTO = new NewRoomDTO(0L, 1, 1, 1, "test", 10d);
        Room room = Room.builder()
                .id(newRoomDTO.getId())
                .number(newRoomDTO.getNumber())
                .size(newRoomDTO.getSize())
                .floor(newRoomDTO.getFloor())
                .description(newRoomDTO.getDescription())
                .price(newRoomDTO.getPrice())
                .build();
        List<Room> rooms = new LinkedList<>();
        rooms.add(room);

        Mockito.when(roomRepository.findAll()).thenReturn(rooms);

        assertEquals(rooms, roomService.getAllRooms());
    }
    @Test
    //@WithMockUser(authorities = {"ROLE_ADMIN"}, roles = {"ROLE_ADMIN"})
    void shouldAddRoom(){
        NewRoomDTO newRoomDTO = new NewRoomDTO(0L, 1, 1, 1, "test", 10d);
        Room room = Room.builder()
                .id(newRoomDTO.getId())
                .number(newRoomDTO.getNumber())
                .size(newRoomDTO.getSize())
                .floor(newRoomDTO.getFloor())
                .description(newRoomDTO.getDescription())
                .price(newRoomDTO.getPrice())
                .build();
        List<Room> rooms = new LinkedList<>();
        rooms.add(room);
        Mockito.when(roomRepository.findAll()).thenReturn(rooms);
        Mockito.when(roomRepository.findById(0L)).thenReturn(Optional.empty());
        Mockito.when(roomRepository.save(any(Room.class))).thenReturn(room);
        roomService.addRoom(newRoomDTO);
        assertEquals(rooms, roomService.getAllRooms());
    }
}
