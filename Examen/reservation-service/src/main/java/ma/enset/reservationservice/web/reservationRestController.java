package ma.enset.reservationservice.web;

import ma.enset.reservationservice.Model.Resource;
import ma.enset.reservationservice.clients.resourceRestClient;
import ma.enset.reservationservice.dtos.ClientRequestDto;
import ma.enset.reservationservice.dtos.ClientResponseDto;
import ma.enset.reservationservice.dtos.ReservationRequestDto;
import ma.enset.reservationservice.dtos.ReservationResponseDto;
import ma.enset.reservationservice.entities.client;
import ma.enset.reservationservice.entities.reservation;
import ma.enset.reservationservice.repository.clientRepository;
import ma.enset.reservationservice.repository.reservationRepository;
import ma.enset.reservationservice.service.ClientService;
import ma.enset.reservationservice.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class reservationRestController {
    private reservationRepository reservationRepository;
    private clientRepository clientRepository;
    private resourceRestClient resourceRestClient;
    private ReservationService reservationService;
    private ClientService clientService;

    public reservationRestController(reservationRepository reservationRepository, clientRepository clientRepository, resourceRestClient resourceRestClient,ReservationService reservationService, ClientService clientService) {
        this.reservationRepository = reservationRepository;
        this.clientRepository = clientRepository;
        this.resourceRestClient = resourceRestClient;
        this.reservationService = reservationService;
        this.clientService = clientService;
    }


    @GetMapping("/reservations")
    public List<reservation> resources() {
        List<reservation> reservationList = reservationRepository.findAll();
        //model.addAttribute("resources", resourcesList);
        return reservationList;
    }

    @GetMapping("/reservations/{id}")
    public reservation reservationById(@PathVariable Long id){
        reservation reservation= reservationRepository.findById(id).get();
        client client=clientRepository.findById(reservation.getClientId()).get();
        Resource resource=resourceRestClient.findResourceById(reservation.getResourceId());
        reservation.setClient(client);
        reservation.setResource(resource);
        return reservation;
    }

    @GetMapping("/reservations/idClient/{id}")
    public List<reservation> reservationsByIdClient(@PathVariable String id){
        List<reservation> reservationList=reservationRepository.findByClientId(id);
        return reservationList;
    }

    @GetMapping("/allClients")
    public List<client> clients() {
        List<client> clientList = clientRepository.findAll();
        //model.addAttribute("resources", resourcesList);
        return clientList;
    }

    @GetMapping("/allClients/{id}")
    public client clientById(@PathVariable String id){
        client client= clientRepository.findById(id).get();
        return client;
    }

    @PostMapping("/reservations")
    public ReservationResponseDto save(@RequestBody ReservationRequestDto requestDTO ){
        return reservationService.addReservation(requestDTO);
    }

    @PutMapping("/reservations/{id}")
    public reservation update(@PathVariable Long id,@RequestBody reservation reservation ){
        reservation reservation1= reservationRepository.findById(id).orElseThrow();
        if (reservation.getResNom()!=null)reservation1.setResNom(reservation.getResNom());
        if (reservation.getCreateRes()!=null)reservation1.setCreateRes(reservation.getCreateRes());
        if (reservation.getResContexte()!=null)reservation1.setResContexte(reservation.getResContexte());
        if (reservation.getResDuree()!=null)reservation1.setResDuree(reservation.getResDuree());
        if (reservation.getClientId()!=null)reservation1.setClientId(reservation.getClientId());
        if (reservation.getResourceId()!=null)reservation1.setResourceId(reservation.getResourceId());
        return reservationRepository.save(reservation1);
    }

    @DeleteMapping("/reservations/{id}")
    public void deleteReservation(@PathVariable Long id){
        reservationRepository.deleteById(id);
    }


    @PostMapping("/allClients")
    public ClientResponseDto save(@RequestBody ClientRequestDto requestDTO ){
        return clientService.addClient(requestDTO);
    }

    @PutMapping("/allClients/{id}")
    public client update(@PathVariable String id,@RequestBody client client ){
        client client1= clientRepository.findById(id).orElseThrow();
        if (client.getFirstName()!=null)client1.setFirstName(client.getFirstName());
        if (client.getLastName()!=null)client1.setLastName(client.getLastName());
        if (client.getEmail()!=null)client1.setEmail(client.getEmail());
        if (client.getFonction()!=null)client1.setFonction(client.getFonction());

        return clientRepository.save(client1);
    }

    @DeleteMapping("/allClients/{id}")
    public void deleteClient(@PathVariable String id){
        clientRepository.deleteById(id);
    }




}
