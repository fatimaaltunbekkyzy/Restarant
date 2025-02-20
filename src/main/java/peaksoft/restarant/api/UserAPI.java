package peaksoft.restarant.api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.restarant.dto.*;
import peaksoft.restarant.entities.User;
import peaksoft.restarant.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserAPI {
    private final UserService userService;

@PostMapping("/create-user")
public SimpleResponse createUserByAdmin(@RequestBody User user, @RequestParam Long restaurantId) {
    return userService.createUserByAdmin(user, restaurantId);
    }
    @GetMapping
    List<UserResponse> gerAll() {
    return userService.getAllUser();
}
    @PutMapping("/{id}")
    public SimpleResponse updateRestaurantById(@PathVariable Long id, @RequestBody UserRequest userRequest) {
    return userService.updateUserById(id,userRequest);
}
    @DeleteMapping("/{id}")
    public SimpleResponse deleteRestaurantById(@PathVariable Long id) {
    return userService.deleteUserById(id);
    }
    // Админ тарабынан заявканы кабыл алынат
    @PutMapping("/{userId}/accept")
    public SimpleResponse acceptApplication(@PathVariable Long userId) {
        return userService.acceptApplication(userId);
    }
    // Админ тарабынан заявканы кабыл алынбайт
    @DeleteMapping("/{userId}/reject")
    public SimpleResponse rejectApplication(@PathVariable Long userId) {
        return userService.rejectApplication(userId);
}}
