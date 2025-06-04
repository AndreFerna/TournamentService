package co.com.pragma.api.dto.view;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ViewRequestDto {
    @NotNull
    @Schema(example = "2023-07-22T02:01:00")
    private String date;
    @NotNull
    @Schema(example = "true")
    private Boolean free;
    @NotNull
    @Schema(example = "2")
    private Long idTournament;
    @NotNull
    @Schema(example = "1000")
    private BigDecimal ticketPrice;
}
