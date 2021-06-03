package pl.polsl.hotelmanagementsystem.service.reservation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.hotelmanagementsystem.controller.dto.AddReservationDTO;
import pl.polsl.hotelmanagementsystem.service.checkedIn.CheckedIn;
import pl.polsl.hotelmanagementsystem.service.client.Client;
import pl.polsl.hotelmanagementsystem.service.client.ClientService;
import pl.polsl.hotelmanagementsystem.service.clientFoodPreference.ClientFoodPreference;
import pl.polsl.hotelmanagementsystem.service.clientFoodPreference.ClientFoodPreferenceRepository;
import pl.polsl.hotelmanagementsystem.service.payment.Payment;
import pl.polsl.hotelmanagementsystem.service.residence.Residence;
import pl.polsl.hotelmanagementsystem.service.residence.ResidenceRepository;
import pl.polsl.hotelmanagementsystem.service.room.RoomRepository;
import pl.polsl.hotelmanagementsystem.utils.exception.ObjectExistsException;

import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final ClientFoodPreferenceRepository clientFoodPreferenceRepository;
    private final ResidenceRepository residenceRepository;
    private final ClientService clientService;

    @Transactional
    public String addReservation(AddReservationDTO addReservationDTO){
        List<ClientFoodPreference> clientFoodPreferences = new LinkedList<>();
        List<Payment> payments = new LinkedList<>();
        Client client = clientService.whoami();
        List<Reservation> reservations = new LinkedList<>();
        Residence residence = new Residence();
        Reservation reservation = Reservation.builder()
                .client(client)
                .clientFoodPreferences(clientFoodPreferences)
                .payments(payments)
                .comments(addReservationDTO.getComment())
                .residence(residence)
                .build();
        reservationRepository.save(reservation);
        reservations.add(reservation);

        List<CheckedIn> checkedIns = new LinkedList<>();
        residence = Residence.builder()
                .checkedIns(checkedIns)
                .startDate(addReservationDTO.getStartDate())
                .endDate(addReservationDTO.getEndDate())
                .room(
                        roomRepository.findById(addReservationDTO.getRoomId())
                                .orElseThrow(() -> new ObjectExistsException(
                                        "Room with id " + addReservationDTO.getRoomId() + " does not exist"))
                )
                .reservations(reservations)
                .build();
        residenceRepository.save(residence);

        return "Reservation added";
    }
}
