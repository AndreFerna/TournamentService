package co.com.pragma.model.view;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class View {
    private String url;
    private String date;
    private Boolean free;
    private Long idTournament;
    private Long aforo;
    private String identifier;
    private BigDecimal ticketPrice;
}
