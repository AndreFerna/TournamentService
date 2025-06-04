package co.com.pragma.model.tournament.gateways;

import co.com.pragma.model.tournament.Tournament;
import co.com.pragma.model.view.View;

public interface TournamentRepository {
    Tournament saveTournament(Tournament tournament, Long categoryId, Long platformId, Long videoGameId);
    Integer countTournamentsOrganizer(String organizerId);
    Tournament findById(Long id);
}
