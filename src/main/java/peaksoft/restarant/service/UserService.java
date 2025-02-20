package peaksoft.restarant.service;

import peaksoft.restarant.dto.*;
import peaksoft.restarant.entities.User;

import java.util.List;

public interface UserService {
//    UserResponse createUserWithRestaurant(Long userId, Long restaurantId);

    SimpleResponse createUserByAdmin(User user, Long restaurantId);

    List<UserResponse> getAllUser();

    SimpleResponse updateUserById(Long id,UserRequest userRequest);

    SimpleResponse deleteUserById(Long id);

    SimpleResponse acceptApplication(Long userId);

    SimpleResponse rejectApplication(Long userId);


}
