package ma.enset.reservationservice.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.reservationservice.Model.Resource;
import ma.enset.reservationservice.entities.client;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationResponseDto {
    private Long resId;
    private String resNom;
    private String resContexte;
    private LocalDate createRes;
    private Integer resDuree;
    private ma.enset.reservationservice.entities.client client;
    private String clientId;
    private Resource resource;
    private Long resourceId;
}
