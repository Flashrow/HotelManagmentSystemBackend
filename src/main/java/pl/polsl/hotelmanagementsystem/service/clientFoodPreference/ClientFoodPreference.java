package pl.polsl.hotelmanagementsystem.service.clientFoodPreference;

import lombok.*;
import pl.polsl.hotelmanagementsystem.service.reservation.Reservation;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientFoodPreference {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Reservation reservation;
    private String preference;

}
