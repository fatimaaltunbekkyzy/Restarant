package peaksoft.restarant.service;
import peaksoft.restarant.dto.RestaurantRequest;
import peaksoft.restarant.dto.RestaurantResponse;
import peaksoft.restarant.dto.SimpleResponse;
import peaksoft.restarant.entities.Restaurant;
import peaksoft.restarant.entities.User;

import java.util.List;

public interface RestaurantService {

    SimpleResponse addEmployeeToRestaurant(Long restaurantId, User user);

    List<RestaurantResponse> getAllRestaurant();

    SimpleResponse updateRestaurantById(Long id, RestaurantRequest restaurantRequest);

    SimpleResponse deleteRestaurantById(Long id);

    Restaurant getRestaurantById(Long id);

    SimpleResponse checkVacancy(Long restaurantId);


    SimpleResponse saveRestaurant(RestaurantRequest restaurantRequest);
}
