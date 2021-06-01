package pl.polsl.hotelmanagementsystem.service.clientFoodPreference;

import pl.polsl.hotelmanagementsystem.service.reservation.Reservation;

import javax.persistence.*;

@Entity
public class ClientFoodPreference {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Reservation reservation;
    private String preference;
}
