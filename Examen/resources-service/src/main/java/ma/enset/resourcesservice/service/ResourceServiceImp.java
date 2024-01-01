package ma.enset.resourcesservice.service;

import ma.enset.resourcesservice.dtos.ResourceRequestDto;
import ma.enset.resourcesservice.dtos.ResourceResponseDto;
import ma.enset.resourcesservice.entities.resource;
import ma.enset.resourcesservice.enums.ResourceType;
import ma.enset.resourcesservice.mapper.ResourceMapper;
import ma.enset.resourcesservice.repository.resourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class ResourceServiceImp implements  ResourceService{
    @Autowired
    private resourceRepository resourceRepository;
    @Autowired
    private ResourceMapper resourceMapper;
    @Override
    public ResourceResponseDto addResource(ResourceRequestDto resourceRequestDto) {
        resource resource= ma.enset.resourcesservice.entities.resource.builder()
                .resNom(resourceRequestDto.getResNom())
                .type(resourceRequestDto.getType())
                .build();
        ma.enset.resourcesservice.entities.resource resourceSave=resourceRepository.save(resource);
        ResourceResponseDto resourceResponseDto=resourceMapper.fromResource(resourceSave);
        return resourceResponseDto;
    }
}
