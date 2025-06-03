package co.com.pragma.jpa.adapter;

import co.com.pragma.jpa.entities.PlatformEntity;
import co.com.pragma.jpa.helper.AdapterOperations;
import co.com.pragma.jpa.mapper.PlatformMapper;
import co.com.pragma.jpa.repository.JPAPlatformRepository;
import co.com.pragma.model.config.ErrorCode;
import co.com.pragma.model.config.PragmaException;
import co.com.pragma.model.tournament.Platform;
import co.com.pragma.model.tournament.gateways.PlataformGateway;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class JPARepositoryPlatformAdapter extends AdapterOperations<Platform, PlatformEntity, Long, JPAPlatformRepository> implements PlataformGateway {

    public JPARepositoryPlatformAdapter(JPAPlatformRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Platform.class));
    }

    @Override
    public Platform findByName(String name) {
        PlatformEntity platformEntity = repository.findByName(name);
        if (Objects.isNull(platformEntity)) {
            throw new PragmaException(ErrorCode.B409010);
        }
        return PlatformMapper.toDomain(platformEntity);
    }
}
