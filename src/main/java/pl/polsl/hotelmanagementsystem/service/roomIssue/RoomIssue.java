package pl.polsl.hotelmanagementsystem.service.roomIssue;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.polsl.hotelmanagementsystem.service.client.Client;
import pl.polsl.hotelmanagementsystem.service.room.Room;

import javax.persistence.*;
import java.util.Date;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class RoomIssue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private RoomIssueType roomIssueType;
    private String description;
    private Date date;
    private RoomIssueStatus roomIssueStatus;

    @ManyToOne
    @JoinColumn
    private Client client;
    @ManyToOne
    @JoinColumn
    private Room room;
}
