package pl.polsl.hotelmanagementsystem.service.payment;

import lombok.NoArgsConstructor;
import pl.polsl.hotelmanagementsystem.service.reservation.Reservation;

import javax.persistence.*;
import java.sql.Date;

@Entity
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Reservation reservation;
    private Double cost;
    private Date date;
}
