package ma.enset.reservationservice.service;

import ma.enset.reservationservice.dtos.ClientRequestDto;
import ma.enset.reservationservice.dtos.ClientResponseDto;
import ma.enset.reservationservice.dtos.ReservationRequestDto;
import ma.enset.reservationservice.dtos.ReservationResponseDto;

public interface ClientService {
    ClientResponseDto addClient(ClientRequestDto clientRequestDto);
}
