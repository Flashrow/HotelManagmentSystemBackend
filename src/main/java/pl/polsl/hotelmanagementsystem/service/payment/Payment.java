package pl.polsl.hotelmanagementsystem.service.payment;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Reservation reservation;
    private Double cost;
    private Date date;
}
