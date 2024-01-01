package ma.enset.resourcesservice.service;

import ma.enset.resourcesservice.dtos.ResourceRequestDto;
import ma.enset.resourcesservice.dtos.ResourceResponseDto;

public interface ResourceService {
    ResourceResponseDto addResource(ResourceRequestDto resourceRequestDto);
}
