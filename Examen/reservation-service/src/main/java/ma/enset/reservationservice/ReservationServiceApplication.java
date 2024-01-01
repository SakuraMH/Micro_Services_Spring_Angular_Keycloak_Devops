package ma.enset.reservationservice;

import ma.enset.reservationservice.entities.client;
import ma.enset.reservationservice.entities.reservation;
import ma.enset.reservationservice.repository.clientRepository;
import ma.enset.reservationservice.repository.reservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class ReservationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(reservationRepository reservationRepository, clientRepository clientRepository){
        return args -> {
            client client1=client.builder().cltId(UUID.randomUUID().toString()).firstName("Sanaa").lastName("Mahfoud").email("Sanaa.mahfoud77@gmail.com").fonction("Fonction 1").reservations(null).build();
            client client2=client.builder().cltId(UUID.randomUUID().toString()).firstName("Sakura").lastName("Mahfoud").email("Sakura.mahfoud88@gmail.com").fonction("Fonction 2").build();
            clientRepository.save(client1);
            clientRepository.save(client2);

            List<reservation> reservationList = List.of(
                    reservation.builder()
                            //.resId(UUID.randomUUID().toString())
                            .resNom("Reservation 1")
                            .resContexte("Context 1")
                            .createRes(LocalDate.now())
                            .resDuree(12)
                            .clientId(client1.getCltId())
                            .client(null)
                            .resourceId(1L)
                            .build(),
                    reservation.builder()
                            //.resId(UUID.randomUUID().toString())
                            .resNom("Reservation 2")
                            .resContexte("Context 2")
                            .createRes(LocalDate.now())
                            .resDuree(4)
                            .clientId(client2.getCltId())
                            .client(null)
                            .resourceId(2L)
                            .build(),
                    reservation.builder()
                            //.resId(UUID.randomUUID().toString())
                            .resNom("Reservation 3")
                            .resContexte("Context 3")
                            .createRes(LocalDate.now())
                            .resDuree(4)
                            .clientId(client1.getCltId())
                            .client(null)
                            .resourceId(2L)
                            .build(),
                    reservation.builder()
                            //.resId(UUID.randomUUID().toString())
                            .resNom("Reservation 4")
                            .resContexte("Context 4")
                            .createRes(LocalDate.now())
                            .resDuree(4)
                            .clientId(client1.getCltId())
                            .client(null)
                            .resourceId(1L)
                            .build()

            );
            reservationRepository.saveAll(reservationList);


        };

}
}
