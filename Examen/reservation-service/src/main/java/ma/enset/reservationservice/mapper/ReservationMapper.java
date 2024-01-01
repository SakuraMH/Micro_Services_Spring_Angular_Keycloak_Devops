package ma.enset.reservationservice.mapper;

import ma.enset.reservationservice.dtos.ReservationResponseDto;
import ma.enset.reservationservice.entities.reservation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {
    public ReservationResponseDto fromReservation(reservation reservation){
        ReservationResponseDto reservationResponseDto=new ReservationResponseDto();
        BeanUtils.copyProperties(reservation,reservationResponseDto);
        return reservationResponseDto;
    }
}
