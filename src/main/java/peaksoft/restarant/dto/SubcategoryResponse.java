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
public class SubcategoryResponse {
    Long id;
    String name;

        public SubcategoryResponse(Long id, String name) {
        this.id = id;
        this.name = name;

    }
}
