package peaksoft.restarant.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChequeResponse2 {
        Long id;
        String waiterFullName; // Официанттын толук аты-жөнү
        List<String> menuItems; // Меню Items тизмеси
        int averagePrice; // Орточо баа
        double servicePercentage; // Кызмат акынын пайызы
        double grandTotal; // Кызмат акы кошулгандан кийинки жалпы сумма

    public ChequeResponse2(Long id, String waiterFullName, List<String> menuItems, int averagePrice, double servicePercentage, double grandTotal) {
        this.id = id;
        this.waiterFullName = waiterFullName;
        this.menuItems = menuItems;
        this.averagePrice = averagePrice;
        this.servicePercentage = servicePercentage;
        this.grandTotal = grandTotal;

}}
