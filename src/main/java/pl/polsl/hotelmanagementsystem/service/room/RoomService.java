package pl.polsl.hotelmanagementsystem.service.room;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.hotelmanagementsystem.controller.dto.AddRoomIssueDTO;
import pl.polsl.hotelmanagementsystem.controller.dto.NewRoomDTO;
import pl.polsl.hotelmanagementsystem.service.client.Client;
import pl.polsl.hotelmanagementsystem.service.client.ClientService;
import pl.polsl.hotelmanagementsystem.service.roomIssue.RoomIssue;
import pl.polsl.hotelmanagementsystem.service.roomIssue.RoomIssueRepository;
import pl.polsl.hotelmanagementsystem.service.roomIssue.RoomIssueStatus;
import pl.polsl.hotelmanagementsystem.utils.exception.ObjectExistsException;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    private final RoomIssueRepository roomIssueRepository;
    private final ClientService clientService;

    @Transactional
    public void addRoom(NewRoomDTO newRoomDTO){
        if(roomRepository.findById(newRoomDTO.getId()).isEmpty()){
            Room room = Room.builder()
                    .id(newRoomDTO.getId())
                    .number(newRoomDTO.getNumber())
                    .size(newRoomDTO.getSize())
                    .floor(newRoomDTO.getFloor())
                    .description(newRoomDTO.getDescription())
                    .price(newRoomDTO.getPrice())
                    .build();
            roomRepository.save(room);
        }
        else {
            throw new ObjectExistsException("Room with id: '" + newRoomDTO.getId() + "' already exists");
        }
    }

    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    public void addMyRoomIssue(AddRoomIssueDTO addRoomIssueDTO){
        Client client = clientService.whoami();
        // My understanding is that you only need room_id - client_id is used ONLY when room issue is issued by a client
        RoomIssue roomIssue = RoomIssue.builder()
                .room(roomRepository.findById(addRoomIssueDTO.getRoomId()).orElseThrow())
                .client(client)
                .date(new Date())
                .description(addRoomIssueDTO.getDescription())
                .roomIssueStatus(RoomIssueStatus.REPORTED)
                .build();
        roomIssueRepository.save(roomIssue);
    }
}
