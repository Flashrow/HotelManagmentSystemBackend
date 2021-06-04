package pl.polsl.hotelmanagementsystem.service.clientFoodPreference;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    @JsonIgnore
    private Reservation reservation;
    private String preference;

}
