package co.com.pragma.jpa.adapter;

import co.com.pragma.jpa.entities.TournamentEntity;
import co.com.pragma.jpa.helper.AdapterOperations;
import co.com.pragma.jpa.mapper.TournamentMapper;
import co.com.pragma.jpa.repository.JPATournamentRepository;
import co.com.pragma.model.config.ErrorCode;
import co.com.pragma.model.config.PragmaException;
import co.com.pragma.model.tournament.Tournament;
import co.com.pragma.model.tournament.gateways.TournamentRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class JPARepositoryTournamentAdapter extends AdapterOperations<Tournament, TournamentEntity, Long, JPATournamentRepository>
        implements TournamentRepository {

    public JPARepositoryTournamentAdapter(JPATournamentRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Tournament.class));
    }

    @Override
    public Tournament saveTournament(Tournament tournament, Long categoryId, Long platformId, Long videoGameId) {
        TournamentEntity tournamentEntity = saveData(TournamentMapper.toEntity(tournament, categoryId, platformId, videoGameId));
        if (Objects.isNull(tournamentEntity)) {
            throw new PragmaException(ErrorCode.B409005);
        }
        String categoryAlias = tournament.getCategory();
        return TournamentMapper.toDomain(tournamentEntity, categoryAlias);
    }

    @Override
    public Integer countTournamentsOrganizer(String organizerId) {
        return repository.countTournamentsOrganizer(organizerId);
    }

}
