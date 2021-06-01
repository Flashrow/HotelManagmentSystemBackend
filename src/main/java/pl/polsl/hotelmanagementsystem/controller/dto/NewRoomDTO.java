package pl.polsl.hotelmanagementsystem.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NewRoomDTO {
    Long id;
    Integer number;
    Integer size;
    Integer floor;
    String description;
    Double price;
}
