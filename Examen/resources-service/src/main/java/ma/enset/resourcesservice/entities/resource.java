package ma.enset.resourcesservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.resourcesservice.enums.ResourceType;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
public class resource {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resId;
    private String resNom;
    @Enumerated(EnumType.STRING)
    private ResourceType type;


}
