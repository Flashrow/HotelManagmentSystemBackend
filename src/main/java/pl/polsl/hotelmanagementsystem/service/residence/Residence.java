package pl.polsl.hotelmanagementsystem.service.residence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.polsl.hotelmanagementsystem.service.checkedIn.CheckedIn;
import pl.polsl.hotelmanagementsystem.service.reservation.Reservation;
import pl.polsl.hotelmanagementsystem.service.room.Room;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Residence {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(
            mappedBy = "residence"
    )
    private List<CheckedIn> checkedIns;
    @OneToMany(
            mappedBy = "residence"
    )
    private List<Reservation> reservations;
    @ManyToOne
    @JoinColumn
    private Room room;
    private Date startDate;
    private Date endDate;
}
