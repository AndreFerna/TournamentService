package co.com.pragma.model.tournament.gateways;

import co.com.pragma.model.tournament.Category;

public interface CategoryRepository {

    Category findByAliasCategory(String nameCategory);

}
