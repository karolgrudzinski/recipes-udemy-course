package grudzinski.springudemy.recipes.services;

import grudzinski.springudemy.recipes.domain.Recipe;
import grudzinski.springudemy.recipes.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getRecipeList() {
        return (List<Recipe>) recipeRepository.findAll();
    }
}
