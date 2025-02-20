package peaksoft.restarant.serviceImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.restarant.dto.SimpleResponse;
import peaksoft.restarant.dto.SubcategoryRequest;
import peaksoft.restarant.dto.SubcategoryResponse;
import peaksoft.restarant.entities.Subcategory;
import peaksoft.restarant.repo.SubcategoryRepo;
import peaksoft.restarant.service.SubcategoryService;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SubcategoryServiceImpl implements SubcategoryService {
    private final SubcategoryRepo subcategoryRepo;

    @Override
    public SimpleResponse saveSubcategory(SubcategoryRequest subcategoryRequest) {
        Subcategory subcategory = new Subcategory();
        subcategory.setName(subcategoryRequest.getName());
        subcategoryRepo.save(subcategory);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("subcategory saved")
                .build();
    }

    @Override
    public List<SubcategoryResponse> getSubcategoriesByCategory(Long categoryId) {
        return getSubcategoriesByCategory(categoryId);
    }

    @Override
    public List<SubcategoryResponse> getAllSubcategories() {
        return getAllSubcategories();
    }

    @Override
    public SimpleResponse updateSubcategoryById(Long id, SubcategoryRequest subcategoryRequest) {
        Subcategory subcategory = subcategoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Subcategory табылган жок!"));
        subcategory.setName(subcategoryRequest.getName());
        try {
            subcategoryRepo.save(subcategory);
        } catch (Exception e) {
            return SimpleResponse.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("subcategory update учурунда ката чыкты: " + e.getMessage())
                    .build();
        }
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("subcategory ийгиликтүү update болду")
                .build();
    }
    @Override
    public SimpleResponse deleteSubcategoryById(Long id) {
        try {
            subcategoryRepo.deleteById(id);
            return SimpleResponse.builder()
                    .httpStatus(HttpStatus.OK)
                    .message("subcategory ийгиликтүү өчүрүлдү")
                    .build();
        } catch (Exception e) {
            return SimpleResponse.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("subcategory өчүрүү учурунда ката чыкты: " + e.getMessage())
                    .build();
        }
    }}





















































