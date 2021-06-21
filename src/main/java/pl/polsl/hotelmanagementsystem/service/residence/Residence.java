package pl.polsl.hotelmanagementsystem.service.residence;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import pl.polsl.hotelmanagementsystem.service.checkedIn.CheckedIn;
import pl.polsl.hotelmanagementsystem.service.reservation.Reservation;
import pl.polsl.hotelmanagementsystem.service.room.Room;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn
    private Room room;
    private Date startDate;
    private Date endDate;
}
