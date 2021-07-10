package pl.polsl.hotelmanagementsystem.service.room;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.hotelmanagementsystem.controller.dto.AddRoomIssueDTO;
import pl.polsl.hotelmanagementsystem.controller.dto.NewRoomDTO;
import pl.polsl.hotelmanagementsystem.controller.dto.SingleActiveRoomDTO;
import pl.polsl.hotelmanagementsystem.controller.dto.SingleActiveRoomRemakeDTO;
import pl.polsl.hotelmanagementsystem.service.client.Client;
import pl.polsl.hotelmanagementsystem.service.client.ClientService;
import pl.polsl.hotelmanagementsystem.service.reservation.Reservation;
import pl.polsl.hotelmanagementsystem.service.reservation.ReservationRepository;
import pl.polsl.hotelmanagementsystem.service.residence.ResidenceRepository;
import pl.polsl.hotelmanagementsystem.service.roomIssue.RoomIssue;
import pl.polsl.hotelmanagementsystem.service.roomIssue.RoomIssueRepository;
import pl.polsl.hotelmanagementsystem.service.roomIssue.RoomIssueStatus;
import pl.polsl.hotelmanagementsystem.utils.exception.ObjectExistsException;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    private final RoomIssueRepository roomIssueRepository;
    private final ClientService clientService;
    private final ResidenceRepository residenceRepository;
    private final ReservationRepository reservationRepository;
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

    public void modifyRoom(NewRoomDTO newRoomDTO){
        Room room = roomRepository.findById(newRoomDTO.getId()).orElseThrow();
        room.setNumber(newRoomDTO.getNumber());
        room.setSize(newRoomDTO.getSize());
        room.setFloor(newRoomDTO.getFloor());
        room.setDescription(newRoomDTO.getDescription());
        room.setPrice(newRoomDTO.getPrice());
        roomRepository.save(room);
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
                .roomIssueType(addRoomIssueDTO.getRoomIssueType())
                .roomIssueStatus(RoomIssueStatus.REPORTED)
                .build();
        roomIssueRepository.save(roomIssue);
    }

    public List<RoomIssue> getAllOngoingRoomIssues(){
        return roomIssueRepository.findByRoomIssueStatusIsNot(RoomIssueStatus.RESOLVED);
    }

    public List<RoomIssue> getMyRoomIssues(){
        Client client = clientService.whoami();
        List<RoomIssue> roomIssues = roomIssueRepository.findByClient(client);
        return roomIssues;
    }

    public void startRoomIssue(Long issueId){
        RoomIssue roomIssue = roomIssueRepository.findById(issueId).orElseThrow();
        roomIssue.setRoomIssueStatus(RoomIssueStatus.IN_PROGRESS);
        roomIssueRepository.save(roomIssue);
    }
    public void resolveRoomIssues(Long issueId){
        RoomIssue roomIssue = roomIssueRepository.findById(issueId).orElseThrow();
        roomIssue.setRoomIssueStatus(RoomIssueStatus.RESOLVED);
        roomIssueRepository.save(roomIssue);
    }
    public List<SingleActiveRoomDTO> getActiveRooms(){
        List<Reservation> reservations = reservationRepository.getAllByResidenceEndDateAfter(new Date());
        List<SingleActiveRoomDTO> activeRooms = new LinkedList<>();
        for (Reservation reservation : reservations){
            SingleActiveRoomDTO singleActiveRoomDTO = SingleActiveRoomDTO.builder()
                    .client(reservation.getClient())
                    .room(reservation.getResidence().getRoom())
                    .startDate(reservation.getResidence().getStartDate())
                    .endDate(reservation.getResidence().getEndDate())
                    .build();
            activeRooms.add(singleActiveRoomDTO);
        }
        return activeRooms;
    }
    public List<SingleActiveRoomRemakeDTO> getActiveRoomsRemake(){
        List<Reservation> reservations = reservationRepository.getAllByResidenceEndDateAfter(new Date());
        List<SingleActiveRoomRemakeDTO> activeRooms = new LinkedList<>();
        for (Reservation reservation : reservations){
            SingleActiveRoomRemakeDTO singleActiveRoomRemakeDTO = SingleActiveRoomRemakeDTO.builder()
                    .client(reservation.getClient())
                    .room(reservation.getResidence().getRoom())
                    .startDate(reservation.getResidence().getStartDate())
                    .endDate(reservation.getResidence().getEndDate())
                    .build();
            activeRooms.add(singleActiveRoomRemakeDTO);
        }
        return activeRooms;
    }
}
