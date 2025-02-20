package peaksoft.restarant.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CategoryResponse {
    Long id;
    String name;


    public CategoryResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
