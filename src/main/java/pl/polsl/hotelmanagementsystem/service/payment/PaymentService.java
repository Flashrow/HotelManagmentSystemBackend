package pl.polsl.hotelmanagementsystem.service.payment;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public void acceptPayment(Long paymentId){
        Payment payment = paymentRepository.findById(paymentId).orElseThrow();
        payment.setPaymentStatus(PaymentStatus.ACCEPTED_BY_RECEPTION);
        paymentRepository.save(payment);
    }
}
