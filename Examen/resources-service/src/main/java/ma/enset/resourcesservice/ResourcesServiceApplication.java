package ma.enset.resourcesservice;

import ma.enset.resourcesservice.entities.resource;
import ma.enset.resourcesservice.enums.ResourceType;
import ma.enset.resourcesservice.repository.resourceRepository;
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
public class ResourcesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourcesServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(resourceRepository resourceRepository){
        return args -> {
            List<resource> reourceList = List.of(
                    resource.builder()
                            //.resId(UUID.randomUUID().toString())
                            .resNom("resource 1")
                            .type(ResourceType.MATERIEL_INF0)
                            .build(),
                    resource.builder()
                            //.resId(UUID.randomUUID().toString())
                            .resNom("resource 2")
                            .type(ResourceType.MATERIEL_AUDIO_VUSUEL)
                            .build()

            );
            resourceRepository.saveAll(reourceList);


        };

    }
}
