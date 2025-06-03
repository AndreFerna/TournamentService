package co.com.pragma.jpa.mapper;

import co.com.pragma.jpa.entities.PlatformEntity;
import co.com.pragma.model.tournament.Platform;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PlatformMapper {

    public static Platform toDomain(PlatformEntity platformEntity){
        return Platform.builder()
                .id(platformEntity.getId())
                .name(platformEntity.getName())
                .build();
    }
}
