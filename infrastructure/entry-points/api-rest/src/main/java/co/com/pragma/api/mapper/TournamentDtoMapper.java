package co.com.pragma.api.mapper;

import co.com.pragma.api.dto.tournament.TournamentRequestDto;
import co.com.pragma.api.dto.tournament.TournamentResponseDto;
import co.com.pragma.model.tournament.Tournament;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class TournamentDtoMapper {
    public static Tournament tournamentDtoToTournament(TournamentRequestDto tournamentDto) {
        return Tournament.builder()
                .name(tournamentDto.getName())
                .description(tournamentDto.getDescription())
                .startDate(tournamentDto.getStartDate())
                .endDate(tournamentDto.getEndDate())
                .organizer(tournamentDto.getOrganizer())
                .category(tournamentDto.getCategory())
                .uniqueCode(UUID.randomUUID().toString())
                .isFree(tournamentDto.getFree())
                .platformName(tournamentDto.getPlatformName())
                .videGameName(tournamentDto.getVideoGameName())
                .build();
    }

    public static TournamentResponseDto tournamentToTournamentDto(Tournament tournament) {
        return TournamentResponseDto.builder()
                .name(tournament.getName())
                .description(tournament.getDescription())
                .startDate(tournament.getStartDate())
                .endDate(tournament.getEndDate())
                .organizer(tournament.getOrganizer())
                .category(tournament.getCategory())
                .uniqueCode(tournament.getUniqueCode())
                .free(tournament.isFree())
                .build();
    }

}
