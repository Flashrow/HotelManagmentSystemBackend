package pl.polsl.hotelmanagementsystem.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.polsl.hotelmanagementsystem.service.client.Client;
import pl.polsl.hotelmanagementsystem.service.client.ClientInformationDTO;
import pl.polsl.hotelmanagementsystem.service.room.Room;
import pl.polsl.hotelmanagementsystem.service.room.RoomInformationDTO;
import pl.polsl.hotelmanagementsystem.service.roomIssue.RoomIssue;

import java.util.Date;
import java.util.stream.Collectors;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class SingleActiveRoomDTO {
    private ClientInformationDTO client;
    private RoomInformationDTO room;
    private final Date startDate;
    private final Date endDate;

    public static SingleActiveRoomDTOBuilder builder() {
        return new SingleActiveRoomDTOBuilder();
    }

    public static class SingleActiveRoomDTOBuilder {
        private ClientInformationDTO client;
        private RoomInformationDTO room;
        private Date startDate;
        private Date endDate;

        SingleActiveRoomDTOBuilder() {
        }

        public SingleActiveRoomDTOBuilder client(Client client) {
            this.client = new ClientInformationDTO().builder()
                    .address(client.getAddress())
                    .city(client.getCity())
                    .country(client.getCountry())
                    .email(client.getEmail())
                    .firstName(client.getFirstName())
                    .lastName(client.getLastName())
                    .phoneNumber(client.getPhoneNumber())
                    .postCode(client.getPostCode())
                    .roles(client.getRoles())
                    .id(client.getId())
                    .roomIssues(client.getRoomIssues())
                    .build();
            return this;
        }

        public SingleActiveRoomDTOBuilder room(Room room) {
            this.room = new RoomInformationDTO().builder()
                    .roomIssues(room.getRoomIssues().stream().map(RoomIssue::getId).collect(Collectors.toList()))
                    .description(room.getDescription())
                    .equipmentQuantities(room.getEquipmentQuantities())
                    .expenses(room.getExpenses())
                    .floor(room.getFloor())
                    .id(room.getId())
                    .imageLink(room.getImageLink())
                    .number(room.getNumber())
                    .price(room.getPrice())
                    .size(room.getSize())
                    .build();
            return this;
        }

    }
}
