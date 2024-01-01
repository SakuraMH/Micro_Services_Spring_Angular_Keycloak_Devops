package ma.enset.reservationservice.service;

import ma.enset.reservationservice.dtos.ReservationRequestDto;
import ma.enset.reservationservice.dtos.ReservationResponseDto;

public interface ReservationService {
   ReservationResponseDto addReservation(ReservationRequestDto reservationRequestDto);
}
