package pl.polsl.hotelmanagementsystem.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.polsl.hotelmanagementsystem.service.roomIssue.RoomIssueType;

import java.util.Optional;

@Getter
@AllArgsConstructor
public class AddRoomIssueDTO {
    RoomIssueType roomIssueType;
    String description;
    Long roomId;
    Optional<Long> clientId;
}
