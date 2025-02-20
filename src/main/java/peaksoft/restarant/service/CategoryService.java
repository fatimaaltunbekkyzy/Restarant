package peaksoft.restarant.service;

import org.springframework.stereotype.Service;
import peaksoft.restarant.dto.*;
import peaksoft.restarant.entities.Category;
import peaksoft.restarant.entities.Subcategory;

import java.util.List;
@Service
public interface CategoryService {

    SimpleResponse saveCategory(CategoryRequest categoryRequest);

    List<Category> getAllCategories();

    SimpleResponse deleteCategoryById(Long id);

    Category getCategoryById(Long id);

    SimpleResponse assignSubcategoriesToCategory(Long categoryId);

    List<SubcategoryResponse> getSubcategoriesByCategory(Long categoryId);

    List<CategoryWithSubcategoriesResponse> getCategoriesWithSubcategories();

}
