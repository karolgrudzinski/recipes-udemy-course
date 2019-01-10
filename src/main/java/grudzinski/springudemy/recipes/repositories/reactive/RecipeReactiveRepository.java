package grudzinski.springudemy.recipes.repositories.reactive;

import grudzinski.springudemy.recipes.domain.Recipe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RecipeReactiveRepository extends ReactiveMongoRepository<Recipe, String> {
}
