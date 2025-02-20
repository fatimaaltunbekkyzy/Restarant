package peaksoft.restarant.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.restarant.dto.CategoryResponse;
import peaksoft.restarant.entities.Category;


import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    @Query("select new peaksoft.restarant.dto.CategoryResponse(c.id,c.name)from Category c")
    List<CategoryResponse> getAllCategories();
}
