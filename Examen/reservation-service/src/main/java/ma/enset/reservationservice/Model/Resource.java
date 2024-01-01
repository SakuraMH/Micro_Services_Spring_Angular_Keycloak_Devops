package ma.enset.reservationservice.Model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.enset.reservationservice.enums.ResourceType;
@Getter
@Setter
@ToString
public class Resource {
    private Long resId;
    private String resNom;
    @Enumerated(EnumType.STRING)
    private ResourceType type;
}
