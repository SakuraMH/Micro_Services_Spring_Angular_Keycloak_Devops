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
public class ResourceResponseDto {
    private Long resId;
    private String resNom;
    private ResourceType type;
}
