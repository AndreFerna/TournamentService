package co.com.pragma.model.tournament.gateways;

import co.com.pragma.model.tournament.VideoGame;

public interface VideoGameGateway {
    VideoGame findByName(String name);
}
