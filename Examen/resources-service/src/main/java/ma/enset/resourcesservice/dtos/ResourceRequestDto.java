package ma.enset.resourcesservice.dtos;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.resourcesservice.enums.ResourceType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResourceRequestDto {
    private String resNom;
    private ResourceType type;
}
