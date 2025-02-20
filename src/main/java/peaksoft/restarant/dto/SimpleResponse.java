package peaksoft.restarant.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data//Getter and Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SimpleResponse {
    HttpStatus httpStatus;
    String message;



}
