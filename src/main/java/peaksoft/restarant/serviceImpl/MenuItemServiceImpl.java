package peaksoft.restarant.serviceImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.restarant.dto.SimpleResponse;
import peaksoft.restarant.entities.MenuItem;
import peaksoft.restarant.entities.Restaurant;
import peaksoft.restarant.repo.MenuItemRepo;
import peaksoft.restarant.repo.RestaurantRepo;
import peaksoft.restarant.service.MenuItemService;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepo menuItemRepo;
    private final RestaurantRepo restaurantRepo;

    @Override
    public SimpleResponse createMenuItem(MenuItem menuItem, Long restaurantId) {
        Restaurant restaurant = restaurantRepo.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Ресторан табылган жок"));
        menuItem.setRestaurant(restaurant);
        menuItemRepo.save(menuItem);
        return SimpleResponse.builder()
                .message("Меню элемент ийгиликтүү түзүлдү жана ресторанга кошулду.")
                .build();
    }

    @Override
    public List<MenuItem> getMenuItemsByPriceAndIsVegetarian(Long restaurantId, boolean isVegetarian, boolean sortDesc) {
        if (sortDesc) {
            return menuItemRepo.findAllByRestaurantIdAndIsVegetarianOrderByPriceDesc(restaurantId, isVegetarian);
        } else {
            return menuItemRepo.findAllByRestaurantIdAndIsVegetarianOrderByPriceAsc(restaurantId, isVegetarian);
        }
    }}
