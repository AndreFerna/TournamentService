package co.com.pragma.api.controller;

import co.com.pragma.api.dto.ResponseErrorDto;
import co.com.pragma.api.dto.tournament.TournamentRequestDto;
import co.com.pragma.api.dto.tournament.TournamentResponseDto;
import co.com.pragma.api.dto.view.ViewRequestDto;
import co.com.pragma.api.dto.view.ViewResponseDto;
import co.com.pragma.api.mapper.TournamentDtoMapper;
import co.com.pragma.api.mapper.ViewDtoMapper;
import co.com.pragma.model.config.ErrorCode;
import co.com.pragma.model.config.PragmaException;
import co.com.pragma.model.tournament.Tournament;
import co.com.pragma.model.view.View;
import co.com.pragma.usecase.tournament.TournamentUseCase;
import co.com.pragma.usecase.view.ViewUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.health.HealthComponent;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.health.Status;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/tournament", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Tag(name = "Torneo", description = "Creacion de torneo y vistas")
public class TournamentController {

    private HealthEndpoint healthEndpoint;
    private final TournamentUseCase tournamentUseCase;
    private final ViewUseCase viewUseCase;

    @Operation(
            summary = "Verifica el estado del servicio",
            description = "Este endpoint permite monitorear si el servicio está disponible.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "El servicio está activo"),
            }
    )
    @RequestMapping(path = "/health", method = RequestMethod.HEAD)
    public ResponseEntity<Void> health() {
        HealthComponent healthComponent = healthEndpoint.health();

        if (Status.UP.equals(healthComponent.getStatus())) {
            return ResponseEntity.ok().build();
        } else {
            throw new PragmaException(ErrorCode.SP503);
        }
    }

    @Operation(summary = "Permite crear torneos gratuitos y pagos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Respuesta exitosa", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = TournamentResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseErrorDto.class))}),
            @ApiResponse(responseCode = "409", description = "Se presentan conflictos con los datos de la solicitud", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseErrorDto.class))})
    })
    @PostMapping
    public TournamentResponseDto save(@RequestBody @Valid TournamentRequestDto tournamentDto) {
        Tournament tournament = TournamentDtoMapper.tournamentDtoToTournament(tournamentDto);
        tournament = tournamentUseCase.save(tournament);
        return TournamentDtoMapper.tournamentToTournamentDto(tournament);
    }

    @Operation(summary = "Permite crear vistas gratuitas y pagas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Respuesta exitosa", content = {@Content(mediaType = "appliction/json", schema = @Schema(implementation = ViewResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseErrorDto.class))}),
            @ApiResponse(responseCode = "409", description = "Se presentan conflictos con los datos de la solicitud", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseErrorDto.class))})
    })
    @PostMapping("/view")
    public ViewResponseDto save(@RequestBody @Valid ViewRequestDto viewResponseDto) {
        View view = ViewDtoMapper.viewDtoToView(viewResponseDto);
        return ViewDtoMapper.viewToViewDto(viewUseCase.save(view));
    }

}
