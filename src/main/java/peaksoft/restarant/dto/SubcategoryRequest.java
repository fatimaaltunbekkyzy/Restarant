package peaksoft.restarant.dto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubcategoryRequest {
    String name;

    public SubcategoryRequest(String name) {
        this.name = name;
}}
