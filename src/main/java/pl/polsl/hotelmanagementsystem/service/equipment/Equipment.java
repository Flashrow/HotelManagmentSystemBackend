package pl.polsl.hotelmanagementsystem.service.equipment;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import pl.polsl.hotelmanagementsystem.service.equipmentQuantity.EquipmentQuantity;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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
