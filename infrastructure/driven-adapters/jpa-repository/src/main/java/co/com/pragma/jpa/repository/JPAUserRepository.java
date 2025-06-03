package co.com.pragma.jpa.repository;

import co.com.pragma.jpa.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPAUserRepository extends CrudRepository<UserEntity, String>, QueryByExampleExecutor<UserEntity> {
}
