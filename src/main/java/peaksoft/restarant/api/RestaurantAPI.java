package peaksoft.restarant.api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.restarant.dto.CategoryRequest;
import peaksoft.restarant.dto.RestaurantRequest;
import peaksoft.restarant.dto.RestaurantResponse;
import peaksoft.restarant.dto.SimpleResponse;
import peaksoft.restarant.entities.Restaurant;
import peaksoft.restarant.entities.User;
import peaksoft.restarant.service.RestaurantService;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/restaurants")
public class RestaurantAPI {
    private final RestaurantService restauranServise;

//     CRUD METHODS RESTAURANT
    @PostMapping
    public SimpleResponse saveCategory(@RequestBody RestaurantRequest restaurantRequest) {
        return restauranServise.saveRestaurant(restaurantRequest);
    }
//     Ресторандагы кызматкерлерди текшерүү
    @GetMapping("/{restaurantId}/vacancy")
    public SimpleResponse checkVacancy(@PathVariable Long restaurantId) {
        return restauranServise.checkVacancy(restaurantId);
    }
        // Жаңы кызматкерди ресторанга кошуу
        @PostMapping("/{restaurantId}/employees")
        public SimpleResponse addEmployee(@PathVariable Long restaurantId, @RequestBody User user) {
            return restauranServise.addEmployeeToRestaurant(restaurantId, user);
    }
    @GetMapping
    List<RestaurantResponse> gerAll() {
        return restauranServise.getAllRestaurant();
    }
        @GetMapping("/{id}")
        public Restaurant getRestaurantById(@PathVariable Long id) {
            return restauranServise.getRestaurantById(id);
    }
    // Ресторанды жаңыртуу (PUT)
    @PutMapping("/{id}")
    public SimpleResponse updateRestaurantById(@PathVariable Long id, @RequestBody RestaurantRequest restaurantRequest) {
        return restauranServise.updateRestaurantById(id, restaurantRequest);
    }

    // Ресторанды өчүрүү (DELETE)
    @DeleteMapping("/{id}")
    public SimpleResponse deleteRestaurantById(@PathVariable Long id) {
        return restauranServise.deleteRestaurantById(id);
}}