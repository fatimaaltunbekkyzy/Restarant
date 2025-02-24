package peaksoft.restarant.api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.restarant.dto.SimpleResponse;
import peaksoft.restarant.dto.StopListRequest;
import peaksoft.restarant.dto.StopListResponse;
import peaksoft.restarant.service.StopListServise;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/stopLists")
public class StopListAPI {
private final StopListServise stopListServise;

//CRUD METHODS STOPLIST
    @PostMapping
    public SimpleResponse saveStopList(@RequestBody StopListRequest stopListRequest) {
        return stopListServise.saveStopList(stopListRequest);
    }
    @GetMapping
    public List<StopListResponse> getAllCategories() {
        return stopListServise.getAllStopList();
    }
    @DeleteMapping("/{id}")
    public SimpleResponse deleteStopListById(@PathVariable Long id) {
        return stopListServise.deleteStopListById(id);
    }}