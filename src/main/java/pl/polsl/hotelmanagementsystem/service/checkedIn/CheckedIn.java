package pl.polsl.hotelmanagementsystem.service.checkedIn;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import pl.polsl.hotelmanagementsystem.service.client.Client;
import pl.polsl.hotelmanagementsystem.service.residence.Residence;
import pl.polsl.hotelmanagementsystem.service.review.Review;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CheckedIn {
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
            cascade = CascadeType.ALL,
            mappedBy = "checkedIn"
    )

    private List<Review> reviews;
    private CheckedInStatus checkedInStatus;
}
