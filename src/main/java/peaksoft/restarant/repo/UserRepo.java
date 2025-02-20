package peaksoft.restarant.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.restarant.dto.RestaurantResponse;
import peaksoft.restarant.dto.UserResponse;
import peaksoft.restarant.entities.User;
import peaksoft.restarant.enums.Role;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query("select new peaksoft.restarant.dto.UserResponse(u.id,u.firstName,u.lastName,u.dateOfBirth,u.email,u.password,u.phoneNumber,u.experience,u.role,u.status)from User u")
    List<UserResponse> getAllUser();

    boolean existsByRole(Role role);

    boolean existsByEmail(String email);
}
