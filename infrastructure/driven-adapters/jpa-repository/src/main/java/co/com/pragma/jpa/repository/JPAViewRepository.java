package co.com.pragma.jpa.repository;

import co.com.pragma.jpa.entities.ViewEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPAViewRepository extends CrudRepository<ViewEntity, Long>, QueryByExampleExecutor<ViewEntity> {

    @Query("select count(*) from vista v where v.tournamentId = ?1 and v.free = true")
    Integer countFreeViewsPerTournament(Long tournamentId);
}
