package peaksoft.restarant.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.restarant.entities.MenuItem;

import java.util.List;

public interface MenuItemRepo extends JpaRepository<MenuItem,Long> {


    List<MenuItem> findAllByRestaurantIdAndIsVegetarianOrderByPriceDesc(Long restaurantId, boolean isVegetarian);

    List<MenuItem> findAllByRestaurantIdAndIsVegetarianOrderByPriceAsc(Long restaurantId, boolean isVegetarian);
}
