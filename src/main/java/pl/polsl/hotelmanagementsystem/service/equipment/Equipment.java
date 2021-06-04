package pl.polsl.hotelmanagementsystem.service.equipment;

import lombok.Getter;
import lombok.Setter;
import pl.polsl.hotelmanagementsystem.service.equipmentQuantity.EquipmentQuantity;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(
            mappedBy = "equipment"
    )
    private List<EquipmentQuantity> equipmentQuantities;
}
