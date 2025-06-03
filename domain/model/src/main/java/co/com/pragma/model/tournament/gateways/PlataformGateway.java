package co.com.pragma.model.tournament.gateways;

import co.com.pragma.model.tournament.Platform;

public interface PlataformGateway {
    Platform findByName(String name);
}
