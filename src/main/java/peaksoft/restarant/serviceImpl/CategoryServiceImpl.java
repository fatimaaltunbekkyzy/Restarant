package peaksoft.restarant.serviceImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.restarant.dto.CategoryRequest;
import peaksoft.restarant.dto.CategoryWithSubcategoriesResponse;
import peaksoft.restarant.dto.SimpleResponse;
import peaksoft.restarant.dto.SubcategoryResponse;
import peaksoft.restarant.entities.Category;
import peaksoft.restarant.entities.Subcategory;
import peaksoft.restarant.repo.CategoryRepo;
import peaksoft.restarant.repo.SubcategoryRepo;
import peaksoft.restarant.service.CategoryService;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor

public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
private final SubcategoryRepo subcategoryRepo;

    @Override
    public SimpleResponse saveCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        categoryRepo.save(category);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Category saved")
                .build();
    }
        @Override
        public List<Category> getAllCategories() {
            return categoryRepo.findAll();

    }
    @Override
    public SimpleResponse deleteCategoryById(Long id) {
        try {
            categoryRepo.deleteById(id);
            return SimpleResponse.builder()
                    .httpStatus(HttpStatus.OK)
                    .message("Category ийгиликтүү өчүрүлдү")
                    .build();
        } catch (Exception e) {
            return SimpleResponse.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("Category өчүрүү учурунда ката чыкты: " + e.getMessage())
                    .build();
}}
    @Override
    public Category getCategoryById(Long id) {
        return categoryRepo.findById(id).orElseThrow(()->new RuntimeException("Категория не найдено"));
    }
    @Override
    public SimpleResponse assignSubcategoriesToCategory(Long categoryId) {
        try {
            Category category = categoryRepo.findById(categoryId)
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            List<Subcategory> subcategories = subcategoryRepo.findAll();
            for (Subcategory subcategory : subcategories) {
                subcategory.setCategory(category);
                subcategoryRepo.save(subcategory);
            }
            return SimpleResponse.builder()
                    .httpStatus(HttpStatus.OK)
                    .message("Subcategories successfully assigned")
                    .build();
        } catch (Exception e) {
            return SimpleResponse.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("Error occurred: " + e.getMessage())
                    .build();
        }}
    //групировать
    @Override
    public List<SubcategoryResponse> getSubcategoriesByCategory(Long categoryId) {
        try {
            Category category = categoryRepo.findById(categoryId)
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            List<Subcategory> subcategories = subcategoryRepo.findByCategoryOrderByNameAsc(category);
            return subcategories.stream()
                    .map(subcategory -> new SubcategoryResponse(subcategory.getId(), subcategory.getName()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error fetching subcategories", e);
        }}

    @Override
    public List<CategoryWithSubcategoriesResponse> getCategoriesWithSubcategories() {
        return List.of();
    }
    }


