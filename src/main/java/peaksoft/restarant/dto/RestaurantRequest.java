package peaksoft.restarant.dto;

import lombok.AccessLevel;
import lombok.Data;

import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Data
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantRequest {
    String name;
    String location;
    int numberOfEmployees; //Жумушчулардын саны
    String service;
    String restType;
}
