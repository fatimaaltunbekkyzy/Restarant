package peaksoft.restarant.initializer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import peaksoft.restarant.entities.User;
import peaksoft.restarant.enums.Role;
import peaksoft.restarant.repo.UserRepo;
import java.time.LocalDate;

@Component
public class AdminInitializer implements InitializingBean {
    private final UserRepo userRepo;

    public AdminInitializer(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (!userRepo.existsByRole(Role.ADMIN)) {  // Админ бар же жок экенин текшерүү
            User admin = User.builder()  // User объектин түзүү
                    .firstName("Adilet")  // Админдин аты
                    .lastName("Egemberdiev")  // Админдин фамилиясы
                    .email("adminAdi@restaurant.com")  // Админдин почтасы
                    .password("adminAdi123")  // Админдин паролу
                    .phoneNumber("+996555112233")  // Админдин телефону
                    .dateOfBirth(LocalDate.of(1998, 1, 1))  // Админдин туулган күнү
                    .experience(10)  // Админдин тажрыйбасы
                    .role(Role.ADMIN)  // Админдин ролу
                    .build();
            // Админди сактоо
            userRepo.save(admin);
            System.out.println("Администратор назначен: adminAdi@restaurant.com / adminAdi123");
        } else {
            // Админ алдын ала бар болсо
            System.out.println("Администратор уже назначен");
        }
    }
}
