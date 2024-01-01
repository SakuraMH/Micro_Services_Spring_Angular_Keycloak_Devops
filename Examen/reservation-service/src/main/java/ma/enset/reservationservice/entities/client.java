package ma.enset.reservationservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
public class client {
    @Id
    private String cltId;
    private String firstName;
    private String lastName;
    private String email;
    private String fonction;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<reservation> reservations;

}
