package grudzinski.springudemy.recipes.services;

import grudzinski.springudemy.recipes.commands.CategoryCommand;
import grudzinski.springudemy.recipes.domain.Category;

import java.util.Set;

public interface CategoryService {
    Set<Category> getCategories();
    Set<Category> findCategoriesByDescription(Set<String> descriptions);
    Set<CategoryCommand> findOtherCategories(Set<CategoryCommand> categories);
}
