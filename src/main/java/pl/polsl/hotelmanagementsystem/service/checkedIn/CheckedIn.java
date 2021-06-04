package pl.polsl.hotelmanagementsystem.service.checkedIn;

import lombok.NoArgsConstructor;
import pl.polsl.hotelmanagementsystem.service.client.Client;
import pl.polsl.hotelmanagementsystem.service.residence.Residence;
import pl.polsl.hotelmanagementsystem.service.review.Review;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
public class CheckedIn {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn
    private Client client;
    @ManyToOne
    @JoinColumn
    private Residence residence;
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "checkedIn"
    )
    private List<Review> reviews;
}
