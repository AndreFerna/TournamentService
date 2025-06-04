package co.com.pragma.jpa.mapper;

import co.com.pragma.jpa.entities.TournamentEntity;
import co.com.pragma.model.tournament.Tournament;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class TournamentMapper {

    public static TournamentEntity toEntity(Tournament tournament, Long categoryId, Long platformId, Long videoGameId) {
        return TournamentEntity.builder()
                .name(tournament.getName())
                .description(tournament.getDescription())
                .startDate(LocalDateTime.parse(tournament.getStartDate(),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")))
                .endDate(LocalDateTime.parse(tournament.getEndDate(),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")))
                .organizerId(tournament.getOrganizer())
                .idCategory(categoryId)
                .uniqueCode(tournament.getUniqueCode())
                .free(tournament.isFree())
                .platformId(platformId)
                .videoGameId(videoGameId)
                .build();
    }

    public static Tournament toDomain(TournamentEntity tournamentEntity, String categoryAlias) {
        return Tournament.builder()
                .idTournament(tournamentEntity.getId())
                .name(tournamentEntity.getName())
                .description(tournamentEntity.getDescription())
                .startDate(tournamentEntity.getStartDate().toString())
                .endDate(tournamentEntity.getEndDate().toString())
                .organizer(tournamentEntity.getOrganizerId())
                .category(categoryAlias)
                .uniqueCode(tournamentEntity.getUniqueCode())
                .isFree(tournamentEntity.getFree())
                .build();
    }

}
