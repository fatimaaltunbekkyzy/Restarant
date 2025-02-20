package peaksoft.restarant.api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.restarant.service.StopListServise;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/stopLists")
public class StopListAPI {
private final StopListServise stopListServise;

    }