package peaksoft.restarant.api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.restarant.dto.*;
import peaksoft.restarant.entities.Category;
import peaksoft.restarant.service.CategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/categories")
public class CategoryAPI {
    private final CategoryService categoryService;

    @PostMapping
    public SimpleResponse saveUser(@RequestBody CategoryRequest categoryRequest) {
        return categoryService.saveCategory(categoryRequest);
    }
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }
    @DeleteMapping("/{id}")
    public SimpleResponse deleteRestaurantById(@PathVariable Long id) {
        return categoryService.deleteCategoryById(id);
    }
    @GetMapping("/{categoryId}/subcategories")
    public List<SubcategoryResponse> getSubcategoriesByCategory(@PathVariable Long categoryId) {
        return categoryService.getSubcategoriesByCategory(categoryId);
    }
//групировка кылыш учун
    @GetMapping("/with-subcategories")
    public List<CategoryWithSubcategoriesResponse> getCategoriesWithSubcategories() {
        return categoryService.getCategoriesWithSubcategories();
    }
}