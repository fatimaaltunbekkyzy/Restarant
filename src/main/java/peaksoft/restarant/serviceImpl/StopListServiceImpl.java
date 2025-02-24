package peaksoft.restarant.serviceImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.restarant.dto.SimpleResponse;
import peaksoft.restarant.dto.StopListRequest;
import peaksoft.restarant.dto.StopListResponse;
import peaksoft.restarant.entities.StopList;
import peaksoft.restarant.repo.StopListRepo;;
import peaksoft.restarant.service.StopListServise;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class StopListServiceImpl implements StopListServise {
    private final StopListRepo stopListRepo;
    @Override
    public SimpleResponse saveStopList(StopListRequest stopListRequest) {
       StopList stopList = new StopList();
        stopList.setDate(stopListRequest.getDate());
        stopList.setReason(stopListRequest.getReason());
        stopListRepo.save(stopList);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("StopList saved")
                .build();
    }

    @Override
    public List<StopListResponse> getAllStopList() {
        return stopListRepo.getAllStopList();
    }

    @Override
    public SimpleResponse deleteStopListById(Long id) {
        try {
           stopListRepo.deleteById(id);
            return SimpleResponse.builder()
                    .httpStatus(HttpStatus.OK)
                    .message("StopList ийгиликтүү өчүрүлдү")
                    .build();
        } catch (Exception e) {
            return SimpleResponse.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("StopList өчүрүү учурунда ката чыкты: " + e.getMessage())
                    .build();
    }
}}
