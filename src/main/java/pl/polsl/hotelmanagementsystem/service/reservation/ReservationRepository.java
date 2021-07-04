package pl.polsl.hotelmanagementsystem.service.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.hotelmanagementsystem.service.client.Client;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> getAllByClient(Client client);
    List<Reservation> getAllByResidenceEndDateAfter(Date date);
}
