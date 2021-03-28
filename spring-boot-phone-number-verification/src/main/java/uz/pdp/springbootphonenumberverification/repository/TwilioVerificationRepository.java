package uz.pdp.springbootphonenumberverification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootphonenumberverification.entity.TwilioVerification;


import java.util.Optional;

public interface TwilioVerificationRepository extends JpaRepository<TwilioVerification,Integer> {
    Optional<TwilioVerification> findByPhoneNumberAndVerifiedFalse(String phoneNumber);

}
