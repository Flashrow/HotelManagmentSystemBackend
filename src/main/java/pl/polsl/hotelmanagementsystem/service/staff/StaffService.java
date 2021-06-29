package pl.polsl.hotelmanagementsystem.service.staff;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class StaffService {
    private final StaffRepository staffRepository;

    public Staff getMyDetails(){
        return whoami();
    }

    public Staff whoami(){
        return search(SecurityContextHolder.getContext().getAuthentication().getName());
    }
    private Staff search(String email){
        return staffRepository.findByEmail(email).orElseThrow(()
                -> new EntityNotFoundException("User with email" + email + "does not exist"));
    }
}
