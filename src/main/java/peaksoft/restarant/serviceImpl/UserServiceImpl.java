package peaksoft.restarant.serviceImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.restarant.dto.*;
import peaksoft.restarant.entities.Restaurant;
import peaksoft.restarant.entities.User;
import peaksoft.restarant.enums.RequestStatus;
import peaksoft.restarant.repo.RestaurantRepo;
import peaksoft.restarant.repo.UserRepo;
import peaksoft.restarant.service.UserService;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final RestaurantRepo restaurantRepo;


    @Override
    public SimpleResponse createUserByAdmin(User user, Long restaurantId) {
                // Ресторанды табуу
                Restaurant restaurant = restaurantRepo.findById(restaurantId)
                        .orElseThrow(() -> new RuntimeException("Ресторан табылган жок"));
                if (userRepo.existsByEmail(user.getEmail())) {
                    return SimpleResponse.builder()
                            .message("Электрондук почта уникалдуу болушу керек.")
                            .build();
                }
                if (user.getPosition().equalsIgnoreCase("Chef")) {
                    int age = LocalDate.now().getYear() - user.getDateOfBirth().getYear();
                    if (age < 25 || age > 45) {
                        return SimpleResponse.builder()
                                .message("Повардын жашы 25тен 45ке чейин болушу керек.")
                                .build();
                    }
                    if (user.getExperience() < 2) {
                        return SimpleResponse.builder()
                                .message("Повардын иш стажы 2 жыл болушу керек.")
                                .build();
                    }}
                if (user.getPosition().equalsIgnoreCase("Waiter")) {
                    int age = LocalDate.now().getYear() - user.getDateOfBirth().getYear();
                    if (age < 18 || age > 30) {
                        return SimpleResponse.builder()
                                .message("Официанттын жашы 18ден 30га чейин болушу керек.")
                                .build();
                    }
                    if (user.getExperience() < 1) {
                        return SimpleResponse.builder()
                                .message("Официанттын иш стажы 1 жыл болушу керек.")
                                .build();
                    }}
                String phoneRegex = "^\\+996\\d{9}$";  // +996555123456
                if (!user.getPhoneNumber().matches(phoneRegex)) {
                    return SimpleResponse.builder()
                            .message("Телефон номери туура эмес форматта.")
                            .build();
                }
                if (user.getPassword().length() < 4) {
                    return SimpleResponse.builder()
                            .message("Пароль 4 символдон кем болбошу керек.")
                            .build();
                }
                // Ресторанды кызматкерге автоматтык түрдө кошуу
                user.setRestaurant(restaurant);
                user.setStatus(RequestStatus.PENDING);  // Заявка күтүү абалына коюлат
                userRepo.save(user);
                return SimpleResponse.builder()
                        .message("Кызматкер ийгиликтүү түзүлдү жана ресторанга байланыштуу.")
                        .httpStatus(HttpStatus.OK)
                        .build();
    }
    @Override
    public SimpleResponse acceptApplication(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("Кызматкер табылган жок"));
        if (user.getStatus() == RequestStatus.PENDING) {
            user.setStatus(RequestStatus.ACTIVE); // Заявканы кабыл алуу, актив статуска коюу
            user.setRestaurant(user.getRestaurant()); // Ресторанга кошуу
            userRepo.save(user);
            return SimpleResponse.builder()
                    .message("Заявка кабыл алынды, кызматкер ресторанга кошулду.")
                    .build();
        }
        return SimpleResponse.builder()
                .message("Заявка кабыл алынган же баш тартылган.")
                .build();
    }

    @Override
    public SimpleResponse rejectApplication(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("Кызматкер табылган жок"));
        if (user.getStatus() == RequestStatus.PENDING) {
            userRepo.delete(user); // Кызматкерди өчүрүү
            return SimpleResponse.builder()
                    .message("Заявка баш тартылды, кызматкер өчүрүлдү.")
                    .build();
        }
        return SimpleResponse.builder()
                .message("Заявка баш тартылган же кабыл алынган.")
                .build();
    }

    @Override
    public List<UserResponse> getAllUser() {
        return userRepo.getAllUser();
    }

    @Override
    public SimpleResponse updateUserById(Long id, UserRequest userRequest) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User табылган жок!"));
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setDateOfBirth(userRequest.getDateOfBirth());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        userRepo.save(user);
        try {
            userRepo.save(user);
        } catch (Exception e) {
            return SimpleResponse.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("User update кылып жаткан учурунда ката чыкты: " + e.getMessage())
                    .build();
        }
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("User ийгиликтүү update болду")
                .build();
    }
    @Override
    public SimpleResponse deleteUserById(Long id){
            try {
                userRepo.deleteById(id);
                return SimpleResponse.builder()
                        .httpStatus(HttpStatus.OK)
                        .message("user ийгиликтүү өчүрүлдү")
                        .build();
            } catch (Exception e) {
                return SimpleResponse.builder()
                        .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                        .message("user ди өчүрүү учурунда ката чыкты: " + e.getMessage())
                        .build();
    }}}




