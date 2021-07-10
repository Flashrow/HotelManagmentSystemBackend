package pl.polsl.hotelmanagementsystem.service.equipmentQuantity;

import lombok.*;
import pl.polsl.hotelmanagementsystem.service.equipment.Equipment;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentQuantityDTO {
    private Long id;
    private Integer quantity;
    private Long roomId;
    private Equipment equipment;

    public EquipmentQuantityDTO(EquipmentQuantity equipmentQuantity){
        this.id = equipmentQuantity.getId();
        this.quantity = equipmentQuantity.getQuantity();
        this.equipment = equipmentQuantity.getEquipment();;
        this.roomId = equipmentQuantity.getRoom().getId();
    }
}
