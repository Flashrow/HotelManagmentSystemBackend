package pl.polsl.hotelmanagementsystem.service.clientFoodPreference;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientFoodPreferenceRepository extends JpaRepository<ClientFoodPreference, Long> {
}
