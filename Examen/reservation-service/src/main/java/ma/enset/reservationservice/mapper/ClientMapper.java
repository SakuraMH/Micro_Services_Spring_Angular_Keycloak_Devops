package ma.enset.reservationservice.mapper;

import ma.enset.reservationservice.dtos.ClientResponseDto;
import ma.enset.reservationservice.dtos.ReservationResponseDto;
import ma.enset.reservationservice.entities.client;
import ma.enset.reservationservice.entities.reservation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public ClientResponseDto fromClient(client client){
        ClientResponseDto clientResponseDto=new ClientResponseDto();
        BeanUtils.copyProperties(client,clientResponseDto);
        return clientResponseDto;
    }
}
