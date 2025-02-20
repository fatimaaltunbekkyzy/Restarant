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
public class RestaurantResponse {
    Long id;
    String name;
    String location;
    int numberOfEmployees; //Жумушчулардын саны
    String service;
    String restType;

    public RestaurantResponse(Long id, String name, String location, int numberOfEmployees, String service, String restType) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.numberOfEmployees = numberOfEmployees;
        this.service = service;
        this.restType = restType;
    }
}
