package peaksoft.restarant.dto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MenuItemRequest {
    String name;
    String location;
    String restType;
    int numberOfEmployees;
    String service;

    public MenuItemRequest(String name, String location, String restType, int numberOfEmployees, String service) {
        this.name = name;
        this.location = location;
        this.restType = restType;
        this.numberOfEmployees = numberOfEmployees;
        this.service = service;
    }
}
