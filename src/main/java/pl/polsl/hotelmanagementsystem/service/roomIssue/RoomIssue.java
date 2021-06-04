package pl.polsl.hotelmanagementsystem.service.roomIssue;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import pl.polsl.hotelmanagementsystem.service.client.Client;
import pl.polsl.hotelmanagementsystem.service.room.Room;

import javax.persistence.*;
import java.sql.Date;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class RoomIssue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type; //TODO: change to enum
    private String description;
    private Date date;
    private String status; //TODO: change to enum

    @ManyToOne
    @JoinColumn
    private Client client;
    @ManyToOne
    @JoinColumn
    private Room room;
}
