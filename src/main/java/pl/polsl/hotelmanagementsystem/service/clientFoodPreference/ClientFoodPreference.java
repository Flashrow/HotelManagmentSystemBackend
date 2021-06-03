package pl.polsl.hotelmanagementsystem.service.clientFoodPreference;

import lombok.NoArgsConstructor;
import pl.polsl.hotelmanagementsystem.service.reservation.Reservation;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class ClientFoodPreference {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Reservation reservation;
    private String preference;
    @ManyToOne(optional = false)
    private Reservation clientFoodPreference;


}
