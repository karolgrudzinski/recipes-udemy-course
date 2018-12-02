package grudzinski.springudemy.recipes.services;

import grudzinski.springudemy.recipes.commands.CategoryCommand;
import grudzinski.springudemy.recipes.converters.CategoryToCategoryCommand;
import grudzinski.springudemy.recipes.domain.Category;
import grudzinski.springudemy.recipes.repositories.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryToCategoryCommand categoryToCategoryCommand;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryToCategoryCommand categoryToCategoryCommand) {
        this.categoryRepository = categoryRepository;
        this.categoryToCategoryCommand = categoryToCategoryCommand;
    }

    @Override
    public Set<Category> getCategories() {
        Set<Category> categories = new HashSet<>();
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }

    @Override
    public Set<Category> findCategoriesByDescription(Set<String> descriptions) {
        Set<Category> categories;

        categories = categoryRepository.findByDescriptionIn(descriptions);

        return categories;
    }

    @Override
    public Set<CategoryCommand> findOtherCategories(Set<CategoryCommand> categories) {
        Set<String> descriptions = new HashSet<>();

        categories.forEach(category -> descriptions.add(category.getDescription()));

        Set<CategoryCommand> otherCategoriesCommands = new HashSet<>();

        Set<Category> otherCategories = categoryRepository.findByDescriptionNotIn(descriptions);

        otherCategories.forEach(category ->
                otherCategoriesCommands.add(categoryToCategoryCommand.convert(category)));

        return otherCategoriesCommands;
    }
}
