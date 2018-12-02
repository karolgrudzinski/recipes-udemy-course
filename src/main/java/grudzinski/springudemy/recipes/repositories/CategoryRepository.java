package grudzinski.springudemy.recipes.repositories;

import grudzinski.springudemy.recipes.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
    Set<Category> findByDescriptionIn(Set<String> descriptions);
    Set<Category> findByDescriptionNotIn(Set<String> descriptions);
}
