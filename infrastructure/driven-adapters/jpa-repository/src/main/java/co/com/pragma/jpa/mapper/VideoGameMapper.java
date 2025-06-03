package co.com.pragma.jpa.mapper;

import co.com.pragma.jpa.entities.VideoGameEntity;
import co.com.pragma.model.tournament.VideoGame;
import lombok.experimental.UtilityClass;

@UtilityClass
public class VideoGameMapper {

    public static VideoGame toDomain(VideoGameEntity videoGameEntity){
        return VideoGame.builder()
                .id(videoGameEntity.getId())
                .name(videoGameEntity.getName())
                .typeId(videoGameEntity.getTypeId())
                .build();
    }
}
