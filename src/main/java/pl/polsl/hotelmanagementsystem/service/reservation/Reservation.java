package pl.polsl.hotelmanagementsystem.service.reservation;

import pl.polsl.hotelmanagementsystem.service.client.Client;
import pl.polsl.hotelmanagementsystem.service.clientFoodPreference.ClientFoodPreference;
import pl.polsl.hotelmanagementsystem.service.payment.Payment;

import javax.persistence.*;
import java.util.List;

@Entity
public class Reservation {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Client client;
    @OneToMany
    private List<ClientFoodPreference> clientFoodPreferences;
    @OneToMany
    private List<Payment> payments;
    private String comments;
}
