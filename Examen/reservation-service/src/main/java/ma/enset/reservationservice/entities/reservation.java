package ma.enset.reservationservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import ma.enset.reservationservice.Model.Resource;

import java.time.LocalDate;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
public class reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resId;
    private String resNom;
    private String resContexte;
    private LocalDate createRes;
    private Integer resDuree;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private client client;
    private String clientId;
    @Transient
    private Resource resource;
    private Long resourceId;


}
