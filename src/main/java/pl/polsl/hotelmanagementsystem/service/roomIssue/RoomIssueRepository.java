package pl.polsl.hotelmanagementsystem.service.roomIssue;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.hotelmanagementsystem.service.client.Client;

import java.util.List;

public interface RoomIssueRepository extends JpaRepository<RoomIssue, Long> {
    List<RoomIssue> findByClient(Client client);
    List<RoomIssue> findByRoomIssueStatusIsNot(RoomIssueStatus roomIssueStatus);
}
