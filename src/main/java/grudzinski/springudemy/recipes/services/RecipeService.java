package grudzinski.springudemy.recipes.services;

import grudzinski.springudemy.recipes.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
