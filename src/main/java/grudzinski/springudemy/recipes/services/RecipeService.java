package grudzinski.springudemy.recipes.services;

import grudzinski.springudemy.recipes.commands.RecipeCommand;
import grudzinski.springudemy.recipes.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(String Id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    RecipeCommand findCommandById(String id);

    void deleteById(String idToDelete);
}
