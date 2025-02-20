package peaksoft.restarant.dto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChequeResponse {
    Long id; // Чектин уникалдуу идентификатору
    int priceAverage;//озточо баасы
    LocalDateTime createdAt;

    public ChequeResponse(Long id, int priceAverage, LocalDateTime createdAt) {
        this.id = id;
        this.priceAverage = priceAverage;
        this.createdAt = createdAt;
    }
}
