package pl.polsl.hotelmanagementsystem.service.payment;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import pl.polsl.hotelmanagementsystem.service.reservation.Reservation;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Payment {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Reservation reservation;
    private Double cost;
    private Date date;
    private PaymentStatus paymentStatus;
}
