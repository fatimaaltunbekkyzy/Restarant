package peaksoft.restarant.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StopListRequest {
    String reason;
    LocalDate date;

    public StopListRequest(String reason, LocalDate date) {
        this.reason = reason;
        this.date = date;
    }

}
