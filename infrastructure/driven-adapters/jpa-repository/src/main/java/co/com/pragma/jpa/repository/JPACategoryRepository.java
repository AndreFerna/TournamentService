package co.com.pragma.jpa.repository;

import co.com.pragma.jpa.entities.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPACategoryRepository extends CrudRepository<CategoryEntity, Long>, QueryByExampleExecutor<CategoryEntity> {
    CategoryEntity findByAlias(String alias);

}
