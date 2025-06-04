package co.com.pragma.api.mapper;

import co.com.pragma.api.dto.view.ViewRequestDto;
import co.com.pragma.api.dto.view.ViewResponseDto;
import co.com.pragma.model.view.View;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ViewDtoMapper {

    public static View viewDtoToView(ViewRequestDto viewResponseDto){
        return View.builder()
                .date(viewResponseDto.getDate())
                .free(viewResponseDto.getFree())
                .idTournament(viewResponseDto.getIdTournament())
                .ticketPrice(viewResponseDto.getTicketPrice())
                .build();
    }

    public static ViewResponseDto viewToViewDto(View view){
        return ViewResponseDto.builder()
                .url(view.getUrl())
                .date(view.getDate())
                .free(view.getFree())
                .idTournament(view.getIdTournament())
                .aforo(view.getAforo())
                .identifier(view.getIdentifier())
                .ticketPrice(view.getTicketPrice())
                .build();
    }

}
