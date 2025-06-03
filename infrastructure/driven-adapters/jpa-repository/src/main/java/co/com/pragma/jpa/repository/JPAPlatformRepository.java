package co.com.pragma.jpa.repository;

import co.com.pragma.jpa.entities.PlatformEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPAPlatformRepository extends CrudRepository<PlatformEntity, Long>, QueryByExampleExecutor<PlatformEntity> {
    PlatformEntity findByName(String name);
}
