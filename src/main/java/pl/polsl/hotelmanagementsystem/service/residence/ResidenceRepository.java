package pl.polsl.hotelmanagementsystem.service.residence;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.hotelmanagementsystem.service.room.Room;

import java.util.Date;
import java.util.List;

public interface ResidenceRepository extends JpaRepository<Residence, Long> {
    List<Residence> findAllByRoom(Room room);
    List<Residence> findByEndDateAfter(Date date);
//    Residence findByRoomAndEndDateGreaterThanAndChecked
}
