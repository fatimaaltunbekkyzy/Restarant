package peaksoft.restarant.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryRequest {
    String name;

    public CategoryRequest(String name) {
        this.name = name;
    }
}
