package pl.polsl.hotelmanagementsystem.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class KitchenDishesDTO {
    private final Integer standard;
    private final Integer vegetarian;
    private final Integer vegan;
    private final List<String> clientFoodPreferences;

}
