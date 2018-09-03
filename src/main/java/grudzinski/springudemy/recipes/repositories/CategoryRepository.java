package grudzinski.springudemy.recipes.repositories;

import grudzinski.springudemy.recipes.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
