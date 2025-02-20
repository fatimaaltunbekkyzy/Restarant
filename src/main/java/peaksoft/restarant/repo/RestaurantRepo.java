package peaksoft.restarant.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.restarant.dto.RestaurantResponse;
import peaksoft.restarant.entities.Restaurant;
import java.util.List;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {
    @Query("select new peaksoft.restarant.dto.RestaurantResponse(r.id,r.name,r.location,r.numberOfEmployees,r.service,r.restType)from Restaurant r")
    List<RestaurantResponse> getAllRestaurant();
}
