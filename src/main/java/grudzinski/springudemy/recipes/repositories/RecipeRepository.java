package grudzinski.springudemy.recipes.repositories;

import grudzinski.springudemy.recipes.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
