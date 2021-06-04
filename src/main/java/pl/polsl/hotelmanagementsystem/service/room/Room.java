package pl.polsl.hotelmanagementsystem.service.room;

import lombok.*;
import pl.polsl.hotelmanagementsystem.service.equipmentQuantity.EquipmentQuantity;
import pl.polsl.hotelmanagementsystem.service.expense.Expense;
import pl.polsl.hotelmanagementsystem.service.residence.Residence;
import pl.polsl.hotelmanagementsystem.service.roomIssue.RoomIssue;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer size;
    private Integer floor;
    private String description;
    private Double price;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "room"
    )
    private List<RoomIssue> roomIssues;
    @OneToMany
    private List<Residence> residences;
    @OneToMany
    private List<Expense> expenses;
    @OneToMany
    private List<EquipmentQuantity> equipmentQuantities;
}
