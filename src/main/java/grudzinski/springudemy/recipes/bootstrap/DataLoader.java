package grudzinski.springudemy.recipes.bootstrap;

import grudzinski.springudemy.recipes.domain.*;
import grudzinski.springudemy.recipes.repositories.CategoryRepository;
import grudzinski.springudemy.recipes.repositories.RecipeRepository;
import grudzinski.springudemy.recipes.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataLoader implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeRepository recipeRepository;

    public DataLoader(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        UnitOfMeasure teaSpoonUnit = unitOfMeasureRepository.findByDescription("Teaspoon").get();
        UnitOfMeasure tableSpoonUnit = unitOfMeasureRepository.findByDescription("Tablespoon").get();
        UnitOfMeasure dashUnit = unitOfMeasureRepository.findByDescription("Dash").get();
        Category mexicanCategory = categoryRepository.findByDescription("Mexican").get();
        Category veganCategory = categoryRepository.findByDescription("Vegan").get();

        // https://www.simplyrecipes.com/recipes/perfect_guacamole/
        Recipe guacamole = new Recipe();
        guacamole.setDescription("Perfect guacamole");
        guacamole.setPrepTime(10);
        guacamole.setCookTime(0);
        guacamole.setServings(4);
        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamole.getCategories().add(mexicanCategory);
        guacamole.getCategories().add(veganCategory);

        // 2 ripe avocados
        Ingredient avocado = new Ingredient();
        avocado.setDescription("ripe avocado");
        avocado.setAmount(BigDecimal.valueOf(2));
        avocado.setRecipe(guacamole);
        guacamole.getIngredients().add(avocado);

        // 1/2 teaspoon Kosher salt
        Ingredient kosherSalt = new Ingredient();
        kosherSalt.setDescription("Kosher salt");
        kosherSalt.setAmount(BigDecimal.valueOf(0.5));
        kosherSalt.setUom(teaSpoonUnit);
        kosherSalt.setRecipe(guacamole);
        guacamole.getIngredients().add(kosherSalt);

        // 1 Tbsp of fresh lime juice or lemon juice
        Ingredient limeJuice = new Ingredient();
        limeJuice.setDescription("fresh lime juice or lemon juice");
        limeJuice.setAmount(BigDecimal.valueOf(1));
        limeJuice.setUom(tableSpoonUnit);
        limeJuice.setRecipe(guacamole);
        guacamole.getIngredients().add(limeJuice);

        // 2 Tbsp to 1/4 cup of minced red onion or thinly sliced green onion
        Ingredient redOnion = new Ingredient();
        redOnion.setDescription("minced red onion or thinly sliced green onion");
        redOnion.setAmount(BigDecimal.valueOf(2));
        redOnion.setUom(tableSpoonUnit);
        redOnion.setRecipe(guacamole);
        guacamole.getIngredients().add(redOnion);

        // 1-2 serrano chiles, stems and seeds removed, minced
        Ingredient chiles = new Ingredient();
        chiles.setDescription("serrano chiles, stems and seeds removed, minced");
        chiles.setAmount(BigDecimal.valueOf(2));
        chiles.setRecipe(guacamole);
        guacamole.getIngredients().add(chiles);

        // 2 tablespoons cilantro (leaves and tender stems), finely chopped
        Ingredient cilantro = new Ingredient();
        cilantro.setDescription("cilantro (leaves and tender stems), finely chopped");
        cilantro.setAmount(BigDecimal.valueOf(2));
        cilantro.setUom(tableSpoonUnit);
        cilantro.setRecipe(guacamole);
        guacamole.getIngredients().add(cilantro);

        // A dash of freshly grated black pepper
        Ingredient blackPepper = new Ingredient();
        blackPepper.setDescription("freshly grated black pepper");
        blackPepper.setUom(dashUnit);
        blackPepper.setRecipe(guacamole);
        guacamole.getIngredients().add(blackPepper);

        // 1/2 ripe tomato, seeds and pulp removed, chopped
        Ingredient tomato = new Ingredient();
        tomato.setDescription("ripe tomato, seeds and pulp removed, chopped");
        tomato.setAmount(BigDecimal.valueOf(0.5));
        tomato.setRecipe(guacamole);
        guacamole.getIngredients().add(tomato);

        Notes guacamoleNote = new Notes();
        guacamoleNote.setRecipeNotes(new String("Guacamole, a dip made from avocados, is originally from Mexico. The name is derived from two Aztec Nahuatl words—ahuacatl (avocado) and molli (sauce).\n" +
                "Making Guacamole is easy\n" +
                "\n" +
                "All you really need to make guacamole is ripe avocados and salt. After that, a little lime or lemon juice—a splash of acidity—will help to balance the richness of the avocado. Then if you want, add chopped cilantro, chiles, onion, and/or tomato.\n" +
                "\n" +
                "Once you have basic guacamole down, feel free to experiment with variations including strawberries, peaches, pineapple, mangoes, even watermelon. You can get creative with homemade guacamole!\n" +
                "Guacamole Tip: Use Ripe Avocados\n" +
                "\n" +
                "The trick to making perfect guacamole is using ripe avocados that are just the right amount of ripeness. Not ripe enough and the avocado will be hard and tasteless. Too ripe and the taste will be off.\n" +
                "\n" +
                "Check for ripeness by gently pressing the outside of the avocado. If there is no give, the avocado is not ripe yet and will not taste good. If there is a little give, the avocado is ripe. If there is a lot of give, the avocado may be past ripe and not good. In this case, taste test first before using."));
        guacamoleNote.setRecipe(guacamole);
        guacamole.setNotes(guacamoleNote);

        guacamole.setDirections(new String("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "Variations\n" +
                "\n" +
                "For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\n" +
                "\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great."));

        recipeRepository.save(guacamole);
    }
}
