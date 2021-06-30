package pl.polsl.hotelmanagementsystem.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
public class AddReservationDTO {
    private final String comment;
    private final Long roomId;
    private final Date startDate;
    private final Date endDate;
    private final List<AddFoodPreferenceDTO> foodPreferences;
}
