package pl.polsl.hotelmanagementsystem.service.reservation;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import pl.polsl.hotelmanagementsystem.service.client.Client;
import pl.polsl.hotelmanagementsystem.service.clientFoodPreference.ClientFoodPreference;
import pl.polsl.hotelmanagementsystem.service.payment.Payment;
import pl.polsl.hotelmanagementsystem.service.residence.Residence;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//@JsonIdentityReference(alwaysAsId = true)
public class Reservation {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn
    @JsonIdentityReference(alwaysAsId = true)
    private Client client;
    @ManyToOne
    @JoinColumn
    @JsonIdentityReference(alwaysAsId = true)
    private Residence residence;
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "reservation"
    )
    private List<ClientFoodPreference> clientFoodPreferences;
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "reservation"
    )
    private List<Payment> payments;
    private String comments;
}
