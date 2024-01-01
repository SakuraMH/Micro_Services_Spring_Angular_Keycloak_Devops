package ma.enset.reservationservice.service;

import ma.enset.reservationservice.dtos.ClientRequestDto;
import ma.enset.reservationservice.dtos.ClientResponseDto;
import ma.enset.reservationservice.entities.client;
import ma.enset.reservationservice.mapper.ClientMapper;
import ma.enset.reservationservice.repository.clientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class ClientServiceImp implements   ClientService{
    @Autowired
    private clientRepository clientRepository;
    @Autowired
    private ClientMapper clientMapper;
    @Override
    public ClientResponseDto addClient(ClientRequestDto clientRequestDto) {
        client client= ma.enset.reservationservice.entities.client.builder()
                .cltId(UUID.randomUUID().toString())
                .firstName(clientRequestDto.getFirstName())
                .lastName(clientRequestDto.getLastName())
                .email(clientRequestDto.getEmail())
                .fonction(clientRequestDto.getFonction())
                .reservations(null)
                .build();
        client client1=clientRepository.save(client);
        ClientResponseDto clientResponseDto=clientMapper.fromClient(client1);
        return clientResponseDto;
    }
}
