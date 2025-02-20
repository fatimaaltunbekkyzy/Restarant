package peaksoft.restarant.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.restarant.dto.RestaurantResponse;
import peaksoft.restarant.dto.SubcategoryResponse;
import peaksoft.restarant.entities.Category;
import peaksoft.restarant.entities.Subcategory;

import java.util.List;

@Repository
public interface SubcategoryRepo extends JpaRepository<Subcategory,Long> {
    @Query("select new peaksoft.restarant.dto.SubcategoryResponse(s.id,s.name)from Subcategory s")
List<SubcategoryResponse> getAllSubcategory();

    // Категорияга тиешелүү сабкатегорияларды аттары боюнча сорттоо
    List<Subcategory> findByCategoryOrderByNameAsc(Category category);
}
