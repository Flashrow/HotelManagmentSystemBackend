package pl.polsl.hotelmanagementsystem.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.polsl.hotelmanagementsystem.service.client.Client;
import pl.polsl.hotelmanagementsystem.service.room.Room;

import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class SingleActiveRoomDTO {
    private final Room room;
    private final Client client;
    private final Date startDate;
    private final Date endDate;
}
