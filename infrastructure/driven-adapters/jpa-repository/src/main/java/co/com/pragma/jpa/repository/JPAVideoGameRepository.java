package co.com.pragma.jpa.repository;

import co.com.pragma.jpa.entities.VideoGameEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPAVideoGameRepository extends CrudRepository<VideoGameEntity, Long>, QueryByExampleExecutor<VideoGameEntity> {
    VideoGameEntity findByName(String name);
}
