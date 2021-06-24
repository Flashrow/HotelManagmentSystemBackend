package pl.polsl.hotelmanagementsystem.service.checkedIn;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.polsl.hotelmanagementsystem.service.client.Client;
import pl.polsl.hotelmanagementsystem.service.client.ClientRepository;
import pl.polsl.hotelmanagementsystem.service.residence.Residence;
import pl.polsl.hotelmanagementsystem.service.residence.ResidenceRepository;
import pl.polsl.hotelmanagementsystem.service.review.Review;
import pl.polsl.hotelmanagementsystem.service.review.ReviewRepository;

import java.util.Date;
import java.util.LinkedList;

@Service
@AllArgsConstructor
public class CheckedInService {
    private final CheckedInRepository checkedInRepository;
    private final ClientRepository clientRepository;
    private final ResidenceRepository residenceRepository;
    private final ReviewRepository reviewRepository;

    public void checkIn(Long clientId, Long residenceId) {
        Client client = clientRepository.findById(clientId).orElseThrow();
        Residence residence = residenceRepository.findById(residenceId).orElseThrow();
        CheckedIn checkedIn = CheckedIn.builder()
                .client(client)
                .residence(residence)
                .reviews(new LinkedList<Review>())
                .checkedInStatus(CheckedInStatus.CHECKED_IN)
                .build();
        checkedInRepository.save(checkedIn);
    }

    public void checkOut(Long checkedInId){
        CheckedIn checkedIn = checkedInRepository.findById(checkedInId).orElseThrow();
        checkedIn.setCheckedInStatus(CheckedInStatus.CHECKED_OUT);
        checkedInRepository.save(checkedIn);
    }

    public void addReview(Long checkedInId, Date date, String content){
        CheckedIn checkedIn = checkedInRepository.findById(checkedInId).orElseThrow();
        Review review = Review.builder()
                .checkedIn(checkedIn)
                .date(date)
                .content(content)
                .build();
        reviewRepository.save(review);
    }
}
