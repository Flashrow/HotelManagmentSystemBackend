package pl.polsl.hotelmanagementsystem.service.equipment;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDTO {
    private Long id;
    private String name;

    public EquipmentDTO(Equipment equipment){
        this.id = equipment.getId();
        this.name = equipment.getName();
    }
}
