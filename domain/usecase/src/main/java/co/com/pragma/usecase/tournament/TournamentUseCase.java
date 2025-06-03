package co.com.pragma.usecase.tournament;

import co.com.pragma.model.config.ErrorCode;
import co.com.pragma.model.config.PragmaException;
import co.com.pragma.model.tournament.Category;
import co.com.pragma.model.tournament.Platform;
import co.com.pragma.model.tournament.Tournament;
import co.com.pragma.model.tournament.VideoGame;
import co.com.pragma.model.tournament.gateways.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TournamentUseCase {

    private final TournamentRepository tournamentRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final PlataformGateway plataformGateway;
    private final VideoGameGateway videoGameGateway;

    public Tournament save(Tournament tournament) {
        Category category = categoryRepository.findByAliasCategory(tournament.getCategory());

        validateExistsUser(tournament.getOrganizer());
        validateFreeAndCapacity(tournament);

        Platform platform = plataformGateway.findByName(tournament.getPlatformName());
        VideoGame videoGame = videoGameGateway.findByName(tournament.getVideGameName());

        Tournament tournamentSaved = tournamentRepository.saveTournament(tournament, category.getCategoryId(), platform.getId(), videoGame.getId());

        return tournamentSaved;
    }

    private void validateExistsUser(String organizerId) {
        boolean userExists = userRepository.exitsById(organizerId);
        if (!userExists) {
            throw new PragmaException(ErrorCode.B409000);
        }
    }

    private void validateFreeAndCapacity(Tournament tournament) {
        if (tournament.isFree()) {
            Integer numberTournament = tournamentRepository.countTournamentsOrganizer(tournament.getOrganizer());
            if (numberTournament > 1) {
                throw new PragmaException(ErrorCode.B409003);
            }
            tournament.setCapacity(100L);
        }
    }
}
