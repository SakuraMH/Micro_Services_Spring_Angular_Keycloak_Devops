package ma.enset.resourcesservice.repository;


import ma.enset.resourcesservice.entities.resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface resourceRepository extends JpaRepository<resource,Long> {
}
