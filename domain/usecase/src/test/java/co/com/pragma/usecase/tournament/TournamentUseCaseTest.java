package co.com.pragma.usecase.tournament;

import co.com.pragma.model.config.PragmaException;
import co.com.pragma.model.tournament.Category;
import co.com.pragma.model.tournament.Platform;
import co.com.pragma.model.tournament.Tournament;
import co.com.pragma.model.tournament.VideoGame;
import co.com.pragma.model.tournament.gateways.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static co.com.pragma.model.config.ErrorCode.B409000;
import static co.com.pragma.model.config.ErrorCode.B409003;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class TournamentUseCaseTest {

    @Mock
    private TournamentRepository tournamentRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private PlataformGateway plataformGateway;
    @Mock
    private VideoGameGateway videoGameGateway;
    @InjectMocks
    private TournamentUseCase tournamentUseCase;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    };

    @Test
    void save() {
        Category category = new Category(11L, "Juegos de Deportes", "sports");
        Platform platform = new Platform(1L, "Discord");
        VideoGame videoGame = new VideoGame(1L, "Free file", 1L);
        Tournament tournament = new Tournament(2L, "Toneo 2", "Prueba", "2025-05-15 02:00:00", "2025-05-16 02:00:00", "1193134338", "Juegos de Deportes", "014cbce5-4f37-43da-85a0-9eeb0c0499de", false, "Discord", "Free fire");

        when(categoryRepository.findByAliasCategory("Juegos de Deportes")).thenReturn(category);
        when(userRepository.exitsById("1193134338")).thenReturn(true);
        when(tournamentRepository.countTournamentsOrganizer("1193134338")).thenReturn(1);
        when(plataformGateway.findByName("Discord")).thenReturn(platform);
        when(videoGameGateway.findByName("Free fire")).thenReturn(videoGame);
        when(tournamentRepository.saveTournament(tournament, 11L, 1L, 1L)).thenReturn(tournament);

        Tournament tournamentTest = tournamentUseCase.save(tournament);

        Assertions.assertEquals(tournamentTest, tournament);
    }

    @Test
    void validateExistsUser(){
        Category category = new Category(11L, "Juegos de Deportes", "sports");
        Tournament tournament = new Tournament(2L, "Toneo 2", "Prueba", "2025-05-15 02:00:00", "2025-05-16 02:00:00", "0000", "Juegos de Deportes", "014cbce5-4f37-43da-85a0-9eeb0c0499de", false, "Discord", "Free fire");

        when(categoryRepository.findByAliasCategory("Juegos de Deportes")).thenReturn(category);
        when(userRepository.exitsById("0000")).thenReturn(false);

        PragmaException exception = assertThrows(PragmaException.class, () -> {
            tournamentUseCase.save(tournament);
        });

        assertEquals(B409000, exception.getError());
    }

    @Test
    void validateFree(){
        Category category = new Category(11L, "Juegos de Deportes", "sports");
        Tournament tournament = new Tournament(2L, "Toneo 2", "Prueba", "2025-05-15 02:00:00", "2025-05-16 02:00:00", "1193134338", "Juegos de Deportes", "014cbce5-4f37-43da-85a0-9eeb0c0499de", true, "Discord", "Free fire");

        when(categoryRepository.findByAliasCategory("Juegos de Deportes")).thenReturn(category);
        when(userRepository.exitsById("1193134338")).thenReturn(true);
        when(tournamentRepository.countTournamentsOrganizer("1193134338")).thenReturn(2);

        PragmaException exception = assertThrows(PragmaException.class, () -> {
            tournamentUseCase.save(tournament);
        });

        assertEquals(B409003, exception.getError());
    }

}