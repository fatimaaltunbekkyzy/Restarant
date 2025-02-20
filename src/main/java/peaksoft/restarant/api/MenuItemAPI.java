package peaksoft.restarant.api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.restarant.dto.SimpleResponse;
import peaksoft.restarant.entities.MenuItem;
import peaksoft.restarant.service.MenuItemService;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/menuItems")
public class MenuItemAPI {
    private MenuItemService menuItemService;

    @PostMapping("/create")
    public SimpleResponse createMenuItem(@RequestBody MenuItem menuItem, @RequestParam Long restaurantId) {
        return menuItemService.createMenuItem(menuItem, restaurantId);
    }
    // Баа боюнча сортировка жана IsVegetarian боюнча фильтрация
    @GetMapping("/sortAndFilter")
    public List<MenuItem> getMenuItemsByPriceAndIsVegetarian(
            @RequestParam Long restaurantId,
            @RequestParam boolean isVegetarian,
            @RequestParam boolean sortDesc) {
        return menuItemService.getMenuItemsByPriceAndIsVegetarian(restaurantId, isVegetarian, sortDesc);
    }
}