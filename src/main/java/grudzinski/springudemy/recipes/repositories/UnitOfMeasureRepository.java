package grudzinski.springudemy.recipes.repositories;

import grudzinski.springudemy.recipes.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
