package grudzinski.springudemy.recipes.bootstrap;

import grudzinski.springudemy.recipes.domain.Category;
import grudzinski.springudemy.recipes.domain.UnitOfMeasure;
import grudzinski.springudemy.recipes.repositories.CategoryRepository;
import grudzinski.springudemy.recipes.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"dev", "prod"})
public class MySQLDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public MySQLDataLoader(CategoryRepository categoryRepository,
                          UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (categoryRepository.count() == 0L){
            log.debug("Loading Categories");
            loadCategories();
        }

        if (unitOfMeasureRepository.count() == 0L){
            log.debug("Loading UOMs");
            loadUom();
        }
    }

    private void loadCategories(){
        Category cat1 = new Category();
        cat1.setDescription("Polish");
        categoryRepository.save(cat1);

        Category cat2 = new Category();
        cat2.setDescription("American");
        categoryRepository.save(cat2);

        Category cat3 = new Category();
        cat3.setDescription("Italian");
        categoryRepository.save(cat3);

        Category cat4 = new Category();
        cat4.setDescription("Mexican");
        categoryRepository.save(cat4);

        Category cat5 = new Category();
        cat5.setDescription("Fast Food");
        categoryRepository.save(cat5);

        Category cat6 = new Category();
        cat6.setDescription("Vegan");
        categoryRepository.save(cat6);
    }

    private void loadUom(){
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setDescription("Each");
        unitOfMeasureRepository.save(uom1);

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setDescription("Teaspoon");
        unitOfMeasureRepository.save(uom2);

        UnitOfMeasure uom3 = new UnitOfMeasure();
        uom3.setDescription("Tablespoon");
        unitOfMeasureRepository.save(uom3);

        UnitOfMeasure uom4 = new UnitOfMeasure();
        uom4.setDescription("Cup");
        unitOfMeasureRepository.save(uom4);

        UnitOfMeasure uom5 = new UnitOfMeasure();
        uom5.setDescription("Pinch");
        unitOfMeasureRepository.save(uom5);

        UnitOfMeasure uom6 = new UnitOfMeasure();
        uom6.setDescription("Dash");
        unitOfMeasureRepository.save(uom6);

        UnitOfMeasure uom7 = new UnitOfMeasure();
        uom7.setDescription("Gram");
        unitOfMeasureRepository.save(uom7);

        UnitOfMeasure uom8 = new UnitOfMeasure();
        uom8.setDescription("Litre");
        unitOfMeasureRepository.save(uom8);

        UnitOfMeasure uom9 = new UnitOfMeasure();
        uom9.setDescription("Millilitre");
        unitOfMeasureRepository.save(uom9);

    }
}
