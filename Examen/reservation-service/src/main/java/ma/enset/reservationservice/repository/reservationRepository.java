package ma.enset.reservationservice.repository;

import ma.enset.reservationservice.entities.reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface reservationRepository extends JpaRepository<reservation,Long> {

    List<reservation> findByClientId(String clientId);
}
