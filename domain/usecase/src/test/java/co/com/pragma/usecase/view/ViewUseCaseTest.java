package co.com.pragma.usecase.view;

import co.com.pragma.model.config.PragmaException;
import co.com.pragma.model.tournament.Tournament;
import co.com.pragma.model.tournament.gateways.TournamentRepository;
import co.com.pragma.model.view.View;
import co.com.pragma.model.view.gateways.ViewRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static co.com.pragma.model.config.ErrorCode.B409000;
import static co.com.pragma.model.config.ErrorCode.B409004;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ViewUseCaseTest {

    @Mock
    private TournamentRepository tournamentRepository;
    @Mock
    private ViewRepository viewRepository;
    @InjectMocks
    private ViewUseCase viewUseCase;

    @Test
    void saveFree() {
        Tournament tournament = new Tournament(2L, "Toneo 2", "Prueba", "2025-05-15 02:00:00", "2025-05-16 02:00:00", "1193134338", "Juegos de Deportes", "014cbce5-4f37-43da-85a0-9eeb0c0499de", true, "Discord", "Free fire");
        View view = new View("prueba", "2025-05-04 02:00:00", true, 1L, 100L, "5cc00214-2058-4377-97a5-daa92662b792", new BigDecimal(1000.00));

        when(tournamentRepository.findById(1L)).thenReturn(tournament);
        when(viewRepository.countFreeViewsPerTournament(1L)).thenReturn(0);
        when(viewRepository.saveView(view)).thenReturn(view);

        View viewTest = viewUseCase.save(view);

        Assertions.assertEquals(viewTest, view);
    }

    @Test
    void saveNotFree(){
        Tournament tournament = new Tournament(2L, "Toneo 2", "Prueba", "2025-05-15 02:00:00", "2025-05-16 02:00:00", "1193134338", "Juegos de Deportes", "014cbce5-4f37-43da-85a0-9eeb0c0499de", true, "Discord", "Free fire");
        View view = new View("prueba", "2025-05-04 02:00:00", false, 1L, 100L, "5cc00214-2058-4377-97a5-daa92662b792", new BigDecimal(1000.0));

        when(tournamentRepository.findById(1L)).thenReturn(tournament);
        when(viewRepository.saveView(view)).thenReturn(view);

        View viewTest = viewUseCase.save(view);

        Assertions.assertEquals(viewTest, view);
    }

    @Test
    void saveFreeException() {
        Tournament tournament = new Tournament(2L, "Toneo 2", "Prueba", "2025-05-15 02:00:00", "2025-05-16 02:00:00", "1193134338", "Juegos de Deportes", "014cbce5-4f37-43da-85a0-9eeb0c0499de", true, "Discord", "Free fire");
        View view = new View("prueba", "2025-05-04 02:00:00", true, 1L, 100L, "5cc00214-2058-4377-97a5-daa92662b792", new BigDecimal(1000.0));

        when(tournamentRepository.findById(1L)).thenReturn(tournament);
        when(viewRepository.countFreeViewsPerTournament(1L)).thenReturn(1);

        PragmaException exception = assertThrows(PragmaException.class, () -> {
            viewUseCase.save(view);
        });

        assertEquals(B409004, exception.getError());
    }
}