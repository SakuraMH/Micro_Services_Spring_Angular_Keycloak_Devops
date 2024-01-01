package ma.enset.reservationservice.clients;

import ma.enset.reservationservice.Model.Resource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RESOURCE-SERVICE")
public interface resourceRestClient {
    @GetMapping("/resources/{id}")
    //@CircuitBreaker(name="customerService", fallbackMethod = "getDefaultCustomer")
    Resource findResourceById(@PathVariable Long id);
    @GetMapping("/resources")
    //@CircuitBreaker(name = "customerService", fallbackMethod = "getAllCustomers")
    List<Resource> allresources();

}
