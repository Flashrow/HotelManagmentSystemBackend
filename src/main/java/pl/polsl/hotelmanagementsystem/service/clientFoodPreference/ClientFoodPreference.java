package pl.polsl.hotelmanagementsystem.service.clientFoodPreference;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import pl.polsl.hotelmanagementsystem.service.reservation.Reservation;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ClientFoodPreference {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Reservation reservation;
    private String preference;

}
