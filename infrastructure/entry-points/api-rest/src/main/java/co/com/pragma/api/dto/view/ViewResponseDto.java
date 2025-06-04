package co.com.pragma.api.dto.view;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class ViewResponseDto {
    @NotNull
    @Schema(example = "https://tournamentview.com/view/8b0863fe-d26d-4bbf-96a7-7424ccdac6b7")
    private String url;
    @NotNull
    @Schema(example = "2023-07-22T02:01:00")
    private String date;
    @NotNull
    @Schema(example = "true")
    private Boolean free;
    @NotNull
    @Schema(example = "2")
    private Long idTournament;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(example = "200")
    private Long aforo;
    @NotNull
    @Schema(example = "8b0863fe-d26d-4bbf-96a7-7424ccdac6b7")
    private String identifier;
    @NotNull
    @Schema(example = "1000")
    private BigDecimal ticketPrice;

}
