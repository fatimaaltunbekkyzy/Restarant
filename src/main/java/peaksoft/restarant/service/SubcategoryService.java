package peaksoft.restarant.service;

import peaksoft.restarant.dto.*;
import peaksoft.restarant.entities.Subcategory;

import java.util.List;

public interface SubcategoryService {

    List<SubcategoryResponse> getAllSubcategories();

    SimpleResponse updateSubcategoryById(Long id, SubcategoryRequest subcategoryRequest);

    SimpleResponse deleteSubcategoryById(Long id);

    SimpleResponse saveSubcategory(SubcategoryRequest subcategoryRequest);

    List<SubcategoryResponse> getSubcategoriesByCategory(Long categoryId);
}
