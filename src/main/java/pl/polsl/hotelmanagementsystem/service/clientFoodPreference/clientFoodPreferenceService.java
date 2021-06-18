package pl.polsl.hotelmanagementsystem.service.clientFoodPreference;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.polsl.hotelmanagementsystem.controller.dto.KitchenDishesDTO;

import java.util.LinkedList;

@Service
@AllArgsConstructor
public class clientFoodPreferenceService {
    private final ClientFoodPreferenceRepository clientFoodPreferenceRepository;

    public KitchenDishesDTO getFoodPreferences(){

        return new KitchenDishesDTO(0,0,0, new LinkedList<>());
    }
}
