package pl.polsl.hotelmanagementsystem.service.equipmentQuantity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import pl.polsl.hotelmanagementsystem.service.equipment.Equipment;
import pl.polsl.hotelmanagementsystem.service.room.Room;

import javax.persistence.*;

@Entity
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EquipmentQuantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn
    private Room room;
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn
    private Equipment equipment;
}
