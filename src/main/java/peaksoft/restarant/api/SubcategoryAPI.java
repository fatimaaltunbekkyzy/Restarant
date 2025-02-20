package peaksoft.restarant.api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import peaksoft.restarant.dto.*;
import peaksoft.restarant.service.CategoryService;
import peaksoft.restarant.service.SubcategoryService;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/subcategories")
public class SubcategoryAPI {
    private final SubcategoryService subcategoryService;
    private final CategoryService categoryService;

    // CRUD METHODS SUBCATEGORY
    @PostMapping
    public SimpleResponse saveUser(@RequestBody SubcategoryRequest subcategoryRequest) {
        return subcategoryService.saveSubcategory(subcategoryRequest);
    }
    @PostMapping("/categories/{categoryId}/assign-subcategories")
    @ResponseBody
    public SimpleResponse assignSubcategoriesToCategory(@PathVariable Long categoryId) {
        return categoryService.assignSubcategoriesToCategory(categoryId);
    }
    @PutMapping("/{id}")
    public SimpleResponse updateRestaurantById(@PathVariable Long id, @RequestBody SubcategoryRequest subcategoryRequest) {
        return subcategoryService.updateSubcategoryById(id, subcategoryRequest);
    }
    // Ресторанды өчүрүү (DELETE)
    @DeleteMapping("/{id}")
    public SimpleResponse deleteRestaurantById(@PathVariable Long id) {
        return subcategoryService.deleteSubcategoryById(id);
    }
    // Сабкатегорияларды категориясы боюнча алабыз
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<SubcategoryResponse>> getSubCategoriesByCategory(@PathVariable Long categoryId) {
        // Сабкатегорияларды алуу
        List<SubcategoryResponse> subCategories = subcategoryService.getSubcategoriesByCategory(categoryId);
        return new ResponseEntity<>(subCategories, HttpStatus.OK);

}}
