package pl.polsl.hotelmanagementsystem.service.roomIssue;

import java.util.Date;

public class RoomIssueInformationDTO {
    private Long id;
    private RoomIssueType roomIssueType;
    private String description;
    private Date date;
    private RoomIssueStatus roomIssueStatus;
    private Long client;
    private Long room;
}
