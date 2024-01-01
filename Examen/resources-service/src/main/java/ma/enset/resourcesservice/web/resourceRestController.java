package ma.enset.resourcesservice.web;

import ma.enset.resourcesservice.dtos.ResourceRequestDto;
import ma.enset.resourcesservice.dtos.ResourceResponseDto;
import ma.enset.resourcesservice.entities.resource;
import ma.enset.resourcesservice.repository.resourceRepository;
import ma.enset.resourcesservice.service.ResourceService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@RestController
public class resourceRestController {
    private resourceRepository resourceRepository;
    private ResourceService resourceService;


    public resourceRestController(resourceRepository resourceRepository, ResourceService resourceService) {
        this.resourceRepository = resourceRepository;

        this.resourceService = resourceService;
    }
    @GetMapping("/resources")
    public List<resource> resources() {
        List<resource> resourcesList = resourceRepository.findAll();
        //model.addAttribute("resources", resourcesList);
        return resourcesList;
    }

    @GetMapping("/resources/{id}")
    public resource ResourceById(@PathVariable Long id){
        resource resource= resourceRepository.findById(id).get();
        return resource;
        //Reservation reservation = customerRestClient.findCustomerById(bankAccount.getCustomerId());

    }

    @PostMapping("/resources")
    public ResourceResponseDto save(@RequestBody ResourceRequestDto requestDTO ){
        return resourceService.addResource(requestDTO);
    }

    @PutMapping("/resources/{id}")
    public resource update(@PathVariable Long id,@RequestBody resource resource ){
        resource resource1= resourceRepository.findById(id).orElseThrow();
        if (resource.getResNom()!=null)resource1.setResNom(resource.getResNom());
        if (resource.getType()!=null)resource1.setType(resource.getType());
        return resourceRepository.save(resource1);
    }

    @DeleteMapping("/resources/{id}")
    public void deleteResource(@PathVariable Long id){
        resourceRepository.deleteById(id);
    }



}
