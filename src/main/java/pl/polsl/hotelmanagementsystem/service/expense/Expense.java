package pl.polsl.hotelmanagementsystem.service.expense;

import lombok.Getter;
import lombok.Setter;
import pl.polsl.hotelmanagementsystem.service.room.Room;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private Date date;
    private String ExpensesType;    //TODO: enum!

    @ManyToOne
    private Room room;
}
