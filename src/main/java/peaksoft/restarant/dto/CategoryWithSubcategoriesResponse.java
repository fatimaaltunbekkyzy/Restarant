package peaksoft.restarant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryWithSubcategoriesResponse {
    private String categoryName;  // Категориянын аты
    private List<SubcategoryResponse> subcategories;  // Сабкатегориялардын тизмеси
}
