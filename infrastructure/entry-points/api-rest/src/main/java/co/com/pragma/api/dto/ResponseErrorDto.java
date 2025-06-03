package co.com.pragma.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseErrorDto {
    @NotNull
    @Schema(example = "4XX-XXX")
    private String code;
    @NotNull
    @Schema(example = "Mensaje de la excepcion")
    private String message;
}
