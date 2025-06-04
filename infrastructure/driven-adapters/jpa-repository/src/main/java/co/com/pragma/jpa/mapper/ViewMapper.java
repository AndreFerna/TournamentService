package co.com.pragma.jpa.mapper;

import co.com.pragma.jpa.entities.ViewEntity;
import co.com.pragma.model.view.View;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class ViewMapper {

    public static ViewEntity toEntity(View view) {
        return ViewEntity.builder()
                .url(view.getUrl())
                .date(LocalDateTime.parse(view.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")))
                .tournamentId(view.getIdTournament())
                .free(view.getFree())
                .aforo(view.getAforo())
                .identifier(view.getIdentifier())
                .ticketPrice(view.getTicketPrice())
                .build();
    }

    public static View toDomain(ViewEntity viewEntity) {
        return View.builder()
                .url(viewEntity.getUrl())
                .date(viewEntity.getDate().toString())
                .free(viewEntity.isFree())
                .idTournament(viewEntity.getTournamentId())
                .aforo(viewEntity.getAforo())
                .identifier(viewEntity.getIdentifier())
                .ticketPrice(viewEntity.getTicketPrice())
                .build();
    }
}
