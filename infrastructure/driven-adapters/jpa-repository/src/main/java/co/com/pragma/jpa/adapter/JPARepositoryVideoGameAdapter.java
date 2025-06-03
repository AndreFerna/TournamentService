package co.com.pragma.jpa.adapter;

import co.com.pragma.jpa.entities.VideoGameEntity;
import co.com.pragma.jpa.helper.AdapterOperations;
import co.com.pragma.jpa.mapper.CategoryMapper;
import co.com.pragma.jpa.mapper.VideoGameMapper;
import co.com.pragma.jpa.repository.JPAVideoGameRepository;
import co.com.pragma.model.config.ErrorCode;
import co.com.pragma.model.config.PragmaException;
import co.com.pragma.model.tournament.VideoGame;
import co.com.pragma.model.tournament.gateways.VideoGameGateway;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class JPARepositoryVideoGameAdapter extends AdapterOperations<VideoGame, VideoGameEntity, Long, JPAVideoGameRepository> implements VideoGameGateway {

    public JPARepositoryVideoGameAdapter(JPAVideoGameRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, VideoGame.class));
    }

    @Override
    public VideoGame findByName(String name) {
        VideoGameEntity videoGameEntity = repository.findByName(name);
        if (Objects.isNull(videoGameEntity)) {
            throw new PragmaException(ErrorCode.B409011);
        }
        return VideoGameMapper.toDomain(videoGameEntity);
    }

}
