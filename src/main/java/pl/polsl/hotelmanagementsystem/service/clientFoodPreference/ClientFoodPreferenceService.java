package pl.polsl.hotelmanagementsystem.service.clientFoodPreference;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.polsl.hotelmanagementsystem.controller.dto.KitchenDishesDTO;
import pl.polsl.hotelmanagementsystem.controller.dto.KitchenTimeOfDayEnum;

import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientFoodPreferenceService {
    private final ClientFoodPreferenceRepository clientFoodPreferenceRepository;

    public KitchenDishesDTO getFoodPreferencesForKitchen(KitchenTimeOfDayEnum timeOfDay){
        Integer standardDishes = 0;
        Integer vegetarianDishes = 0;
        Integer veganDishes = 0;
        List<String> specialDishes = new LinkedList<>();
        List<ClientFoodPreference> clientFoodPreferences = clientFoodPreferenceRepository.findAll();
        for (ClientFoodPreference clientFoodPreference : clientFoodPreferences) {
            ClientFoodPreferenceType clientFoodPreferenceType = clientFoodPreference.getClientFoodPreferenceType();
            if (clientFoodPreferenceType == ClientFoodPreferenceType.STADARD) { standardDishes++; }
            if (clientFoodPreferenceType == ClientFoodPreferenceType.VEGETATIAN) { vegetarianDishes++; }
            if (clientFoodPreferenceType == ClientFoodPreferenceType.VEGAN) {veganDishes++;}
            if (clientFoodPreferenceType == ClientFoodPreferenceType.SPECIAL) {
                specialDishes.add(clientFoodPreference.getPreference());
            }
        }
        return new KitchenDishesDTO(standardDishes, vegetarianDishes, veganDishes, specialDishes);
    }
}
