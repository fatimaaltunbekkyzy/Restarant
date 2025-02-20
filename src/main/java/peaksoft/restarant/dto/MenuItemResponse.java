package peaksoft.restarant.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MenuItemResponse {
    Long id;
    String name;
    String image;
    int price;
    String description;
    boolean isVegetarian;
    String restaurantName;
    String categoryName;
    String subCategoryName;

    public MenuItemResponse(Long id, String name, String image, int price, String description, boolean isVegetarian, String restaurantName, String categoryName, String subCategoryName) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
        this.isVegetarian = isVegetarian;
        this.restaurantName = restaurantName;
        this.categoryName = categoryName;
        this.subCategoryName = subCategoryName;
    }

    public void setSubcategoryName(String name) {
    }
}
