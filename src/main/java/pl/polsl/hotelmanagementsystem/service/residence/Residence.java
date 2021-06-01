package pl.polsl.hotelmanagementsystem.service.residence;

import pl.polsl.hotelmanagementsystem.service.checkedIn.CheckedIn;
import pl.polsl.hotelmanagementsystem.service.reservation.Reservation;
import pl.polsl.hotelmanagementsystem.service.room.Room;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Residence {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<CheckedIn> checkedIns;
    @OneToMany
    private List<Reservation> reservations;
    @ManyToOne
    private Room room;
    private Date startDate;
    private Date endDate;
}
