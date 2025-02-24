package peaksoft.restarant.serviceImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.restarant.dto.RestaurantRequest;
import peaksoft.restarant.dto.RestaurantResponse;
import peaksoft.restarant.dto.SimpleResponse;
import peaksoft.restarant.entities.Restaurant;
import peaksoft.restarant.entities.User;
import peaksoft.restarant.repo.RestaurantRepo;
import peaksoft.restarant.repo.UserRepo;
import peaksoft.restarant.service.RestaurantService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ResteuranServiseImpl implements RestaurantService {
    private final RestaurantRepo restaurantRepo;
    private final UserRepo userRepo;

    @Override
    public SimpleResponse saveRestaurant(RestaurantRequest restaurantRequest) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantRequest.getName());
        restaurant.setLocation(restaurantRequest.getLocation());
        restaurant.setService(restaurantRequest.getService());
        restaurant.setRestType(restaurantRequest.getRestType());
        restaurant.setNumberOfEmployees(restaurantRequest.getNumberOfEmployees());
        restaurantRepo.save(restaurant);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Restaurant saved")
                .build();
}
    @Override
    public SimpleResponse addEmployeeToRestaurant(Long restaurantId, User user) {
        // Ресторанды табуу
        Restaurant restaurant = restaurantRepo.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Ресторан табылган жок"));
        user.setRestaurant(restaurant);
        userRepo.save(user);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Кызматкер ийгиликтүү кошулду")
                .build();
    }

    @Override
    public List<RestaurantResponse> getAllRestaurant() {
        return restaurantRepo.getAllRestaurant();
    }

    @Override
    public SimpleResponse updateRestaurantById(Long id, RestaurantRequest restaurantRequest) {
        Restaurant restaurant = restaurantRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant табылган жок!"));
        restaurant.setName(restaurantRequest.getName());
        restaurant.setLocation(restaurantRequest.getLocation());
        restaurant.setService(restaurantRequest.getService());
        restaurant.setRestType(restaurantRequest.getRestType());
        try {
            restaurantRepo.save(restaurant);
        } catch (Exception e) {
            return SimpleResponse.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("retaurant update учурунда ката чыкты: " + e.getMessage())
                    .build();
        }
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("retaurant ийгиликтүү update болду")
                .build();
    }

    @Override
    public SimpleResponse deleteRestaurantById(Long id) {
        try {
            restaurantRepo.deleteById(id);
            return SimpleResponse.builder()
                    .httpStatus(HttpStatus.OK)
                    .message("Ресторан ийгиликтүү өчүрүлдү")
                    .build();
        } catch (Exception e) {
            return SimpleResponse.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("Ресторанды өчүрүү учурунда ката чыкты: " + e.getMessage())
                    .build();
        }}

    @Override
    public Restaurant getRestaurantById(Long id) {
      return restaurantRepo.findById(id).orElseThrow(()->new RuntimeException("restaurant не найдено"));

    }

    @Override
    public SimpleResponse checkVacancy(Long restaurantId) {
        // Ресторанды табуу
        Restaurant restaurant = restaurantRepo.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Ресторан табылган жок"));
        int employeeCount = restaurant.getUser().size();
        int maxEmployees = 15;
        if (employeeCount < maxEmployees) {
            return SimpleResponse.builder()
                    .httpStatus(HttpStatus.OK)
                    .message("Ресторанда бош орун бар. Кызматкерлер саны: " + employeeCount)
                    .build();
        } else {
            return SimpleResponse.builder()
                    .httpStatus(HttpStatus.FORBIDDEN)
                    .message("Ресторанда бош орун жок. Кызматкерлердин саны жетиштүү.")
                    .build();
    }
}}

