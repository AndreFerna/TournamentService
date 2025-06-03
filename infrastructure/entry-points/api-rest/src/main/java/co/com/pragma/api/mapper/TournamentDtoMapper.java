package co.com.pragma.api.mapper;

import co.com.pragma.api.dto.TournamentRequestDto;
import co.com.pragma.api.dto.TournamentResponseDto;
import co.com.pragma.model.tournament.Tournament;

import java.util.UUID;

public class TournamentDtoMapper {
    public static Tournament tournamentDtoToTournament(TournamentRequestDto tournamentDto) {
        return Tournament.builder()
                .name(tournamentDto.getName())
                .description(tournamentDto.getDescription())
                .startDate(tournamentDto.getStartDate())
                .endDate(tournamentDto.getEndDate())
                .entrancePrice(tournamentDto.getEntrancePrice())
                .organizer(tournamentDto.getOrganizer())
                .category(tournamentDto.getCategory())
                .uniqueCode(UUID.randomUUID().toString())
                .isFree(tournamentDto.getFree())
                .platformName(tournamentDto.getPlatformName())
                .videGameName(tournamentDto.getVideoGameName())
                .build();
    }

    public static TournamentResponseDto tournamentToTounamentDto(Tournament tournament) {
        return TournamentResponseDto.builder()
                .name(tournament.getName())
                .description(tournament.getDescription())
                .startDate(tournament.getStartDate())
                .endDate(tournament.getEndDate())
                .entrancePrice(tournament.getEntrancePrice())
                .capacity(tournament.getCapacity())
                .organizer(tournament.getOrganizer())
                .category(tournament.getCategory())
                .uniqueCode(tournament.getUniqueCode())
                .free(tournament.isFree())
                .build();
    }

}
