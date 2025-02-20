package peaksoft.restarant.service;

import peaksoft.restarant.dto.*;
import peaksoft.restarant.entities.MenuItem;

import java.util.List;

public interface MenuItemService {
    SimpleResponse createMenuItem(MenuItem menuItem, Long restaurantId);

    // Баа боюнча сортировка жана IsVegetarian боюнча фильтрация
    List<MenuItem> getMenuItemsByPriceAndIsVegetarian(Long restaurantId, boolean isVegetarian, boolean sortDesc);

//    SimpleResponse saveMenuItem(MenuItemRequest menuItemRequest);
//
//    List<MenuItemResponse> getAllMenuItems();
//
//    SimpleResponse updateMenuItemById(Long id, MenuItemRequest menuItemRequest);
//
//    SimpleResponse deleteMenuItemById(Long id);
//
//    List<MenuItemResponse> search(String query);
//
//    List<MenuItemResponse> filterByVegetarian(boolean isVegetarian);
//
//    List<MenuItemResponse> sortByPrice(boolean ascending);
}
