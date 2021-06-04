package pl.polsl.hotelmanagementsystem.service.equipmentQuantity;

import lombok.Getter;
import lombok.Setter;
import pl.polsl.hotelmanagementsystem.service.equipment.Equipment;
import pl.polsl.hotelmanagementsystem.service.room.Room;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class EquipmentQuantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;

    @ManyToOne
    @JoinColumn
    private Room room;
    @ManyToOne
    @JoinColumn
    private Equipment equipment;
}
