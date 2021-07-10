package pl.polsl.hotelmanagementsystem.service.room;

import lombok.*;
import pl.polsl.hotelmanagementsystem.service.equipmentQuantity.EquipmentQuantityDTO;
import pl.polsl.hotelmanagementsystem.service.expense.ExpenseDTO;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomInformationDTO {
    private Long id;
    private Integer number;
    private Integer size;
    private Integer floor;
    private String description;
    private Double price;
    private String imageLink;

    private List<Long> roomIssues;
    private List<ExpenseDTO> expenses;
    private List<EquipmentQuantityDTO> equipmentQuantities;
}
