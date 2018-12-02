package grudzinski.springudemy.recipes.services;

import grudzinski.springudemy.recipes.commands.RecipeCommand;
import grudzinski.springudemy.recipes.converters.RecipeCommandToRecipe;
import grudzinski.springudemy.recipes.converters.RecipeToRecipeCommand;
import grudzinski.springudemy.recipes.domain.Recipe;
import grudzinski.springudemy.recipes.exceptions.NotFoundException;
import grudzinski.springudemy.recipes.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeToRecipeCommand recipeToRecipeCommand;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final CategoryService categoryService;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeToRecipeCommand recipeToRecipeCommand, RecipeCommandToRecipe recipeCommandToRecipe, CategoryService categoryService) {
        this.recipeRepository = recipeRepository;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.categoryService = categoryService;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I'm a Service and I serve recipes");
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);

        return recipeSet;
    }

    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);

        if (!recipeOptional.isPresent()) {
            throw new NotFoundException("Recipe not found for Id: " + id);
        }

        return recipeOptional.get();
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);

        if (command.getCategoriesToSave().size() > 0) {
            log.debug(String.valueOf(command.getCategories().size()));
            log.debug(String.valueOf(command.getCategoriesToSave().size()));
            detachedRecipe.getCategories().addAll(
                    categoryService.findCategoriesByDescription(command.getCategoriesToSave()));
            log.debug(String.valueOf(detachedRecipe.getCategories().size()));
        }

        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved RecipeId:" + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }

    @Override
    @Transactional
    public RecipeCommand findCommandById(Long id) {
        return recipeToRecipeCommand.convert(findById(id));
    }

    @Override
    public void deleteById(Long idToDelete) {
        recipeRepository.deleteById(idToDelete);
    }
}
