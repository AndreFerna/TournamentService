package co.com.pragma.usecase.view;

import co.com.pragma.model.config.ErrorCode;
import co.com.pragma.model.config.PragmaException;
import co.com.pragma.model.tournament.Tournament;
import co.com.pragma.model.tournament.gateways.TournamentRepository;
import co.com.pragma.model.view.View;
import co.com.pragma.model.view.gateways.ViewRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ViewUseCase {

    private final ViewRepository viewRepository;
    private final TournamentRepository tournamentRepository;

    public View save(View view) {
        Tournament tournament = tournamentRepository.findById(view.getIdTournament());
        if (Boolean.TRUE.equals(view.getFree())) {
            if (viewRepository.countFreeViewsPerTournament(view.getIdTournament()) > 0) {
                throw new PragmaException(ErrorCode.B409004);
            }
            view.setAforo(200L);
        } else {
            view.setAforo(10000000L);
        }
        String identifier = UUID.randomUUID().toString();
        view.setUrl("https://tournamentview.com/view/?tournament=" + tournament.getUniqueCode() + "&view=" + identifier);
        view.setIdentifier(identifier);
        return viewRepository.saveView(view);
    }

}
