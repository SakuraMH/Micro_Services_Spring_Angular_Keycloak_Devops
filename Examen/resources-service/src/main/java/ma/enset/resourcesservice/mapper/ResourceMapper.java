package ma.enset.resourcesservice.mapper;

import ma.enset.resourcesservice.dtos.ResourceResponseDto;
import ma.enset.resourcesservice.entities.resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ResourceMapper {
    public ResourceResponseDto fromResource(resource resource){
        ResourceResponseDto resourceResponseDto=new ResourceResponseDto();
        BeanUtils.copyProperties(resource,resourceResponseDto);
        return resourceResponseDto;
    }
}
