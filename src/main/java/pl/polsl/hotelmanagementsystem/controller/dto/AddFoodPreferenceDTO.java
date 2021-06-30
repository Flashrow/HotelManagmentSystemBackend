package pl.polsl.hotelmanagementsystem.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.polsl.hotelmanagementsystem.service.clientFoodPreference.ClientFoodPreferenceTimeOfDayType;
import pl.polsl.hotelmanagementsystem.service.clientFoodPreference.ClientFoodPreferenceType;

@Getter
@AllArgsConstructor
public class AddFoodPreferenceDTO {
    private final ClientFoodPreferenceType preferenceType;
    private final ClientFoodPreferenceTimeOfDayType timeOfDayType;
    private final String preference;
}
