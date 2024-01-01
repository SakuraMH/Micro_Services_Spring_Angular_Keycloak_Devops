package ma.enset.reservationservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientResponseDto {
    private String cltId;
    private String firstName;
    private String lastName;
    private String email;
    private String fonction;
}
