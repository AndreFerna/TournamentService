package co.com.pragma.jpa.adapter;

import co.com.pragma.jpa.entities.ViewEntity;
import co.com.pragma.jpa.helper.AdapterOperations;
import co.com.pragma.jpa.mapper.ViewMapper;
import co.com.pragma.jpa.repository.JPAViewRepository;
import co.com.pragma.model.view.View;
import co.com.pragma.model.view.gateways.ViewRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JPARepositoryViewAdapter extends AdapterOperations<View, ViewEntity, Long, JPAViewRepository> implements ViewRepository {

    public JPARepositoryViewAdapter(JPAViewRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, View.class));
    }

    @Override
    public View saveView(View view) {
        ViewEntity viewEntity = saveData(ViewMapper.toEntity(view));
        return ViewMapper.toDomain(viewEntity);
    }

    @Override
    public int countFreeViewsPerTournament(Long tournamentId) {
        return repository.countFreeViewsPerTournament(tournamentId);
    }
}
