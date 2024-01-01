package ma.enset.reservationservice.service;

import ma.enset.reservationservice.dtos.ClientRequestDto;
import ma.enset.reservationservice.dtos.ClientResponseDto;
import ma.enset.reservationservice.dtos.ReservationRequestDto;
import ma.enset.reservationservice.dtos.ReservationResponseDto;
import ma.enset.reservationservice.entities.client;
import ma.enset.reservationservice.entities.reservation;
import ma.enset.reservationservice.mapper.ClientMapper;
import ma.enset.reservationservice.mapper.ReservationMapper;
import ma.enset.reservationservice.repository.clientRepository;
import ma.enset.reservationservice.repository.reservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

@Service
@Transactional
public class ReservationServiceImp implements ReservationService{
    @Autowired
    private reservationRepository reservationRepository;
    @Autowired
    private ReservationMapper reservationMapper;
    @Override
    public ReservationResponseDto addReservation(ReservationRequestDto reservationRequestDto) {
        reservation reservation= ma.enset.reservationservice.entities.reservation.builder()
                .resNom(reservationRequestDto.getResNom())
                .resContexte(reservationRequestDto.getResContexte())
                .createRes(LocalDate.now())
                .resDuree(reservationRequestDto.getResDuree())
                .clientId(reservationRequestDto.getClientId())
                .client(null)
                .resourceId(reservationRequestDto.getResourceId())
                .build();
        reservation reservation1=reservationRepository.save(reservation);
        ReservationResponseDto reservationResponseDto=reservationMapper.fromReservation(reservation1);
        return reservationResponseDto;
    }
}
