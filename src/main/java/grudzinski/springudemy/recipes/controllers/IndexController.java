package grudzinski.springudemy.recipes.controllers;

import grudzinski.springudemy.recipes.domain.Category;
import grudzinski.springudemy.recipes.domain.UnitOfMeasure;
import grudzinski.springudemy.recipes.repositories.CategoryRepository;
import grudzinski.springudemy.recipes.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {
        Optional<Category> categoryOptional = categoryRepository.findByDescription("Italian");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Grams");

        System.out.println("Category id is: " + categoryOptional.get().getId());
        System.out.println("Unit id is:" + unitOfMeasureOptional.get().getId());

        return "index";
    }
}
