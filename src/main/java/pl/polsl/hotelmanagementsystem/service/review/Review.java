package pl.polsl.hotelmanagementsystem.service.review;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import pl.polsl.hotelmanagementsystem.service.checkedIn.CheckedIn;

import javax.persistence.*;
import java.sql.Date;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Review {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn
    private CheckedIn checkedIn;
    private Date date;
    private String content;
}
