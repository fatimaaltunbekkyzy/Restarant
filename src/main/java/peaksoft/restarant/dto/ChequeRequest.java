package peaksoft.restarant.dto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChequeRequest {
    int priceAverage;//озточо баасы
    LocalDateTime createdAt;

    public ChequeRequest(int priceAverage, LocalDateTime createdAt) {
        this.priceAverage = priceAverage;
        this.createdAt = createdAt;
    }
}
