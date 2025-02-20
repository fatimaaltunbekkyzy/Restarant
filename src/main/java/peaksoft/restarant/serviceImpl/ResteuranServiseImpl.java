package peaksoft.restarant.serviceImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.restarant.repo.RestaurantRepo;
import peaksoft.restarant.repo.UserRepo;
@Service
@RequiredArgsConstructor
@Transactional
public class ResteuranServiseImpl {
    private final RestaurantRepo restaurantRepo;
    private final UserRepo userRepo;

}

