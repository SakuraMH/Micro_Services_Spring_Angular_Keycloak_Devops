package ma.enset.reservationservice.repository;

import ma.enset.reservationservice.entities.client;
import ma.enset.reservationservice.entities.reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface clientRepository extends JpaRepository<client,String> {
}
