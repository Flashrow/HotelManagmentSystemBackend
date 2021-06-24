package pl.polsl.hotelmanagementsystem.service.expense;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import pl.polsl.hotelmanagementsystem.service.room.Room;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private Date date;
    private ExpenseType expenseType;

    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn
    private Room room;
}
