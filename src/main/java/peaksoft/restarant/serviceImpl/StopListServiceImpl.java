package peaksoft.restarant.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.restarant.dto.SimpleResponse;
import peaksoft.restarant.dto.StopListRequest;
import peaksoft.restarant.dto.StopListResponse;
import peaksoft.restarant.entities.StopList;
import peaksoft.restarant.repo.SubcategoryRepo;
import peaksoft.restarant.service.StopListServise;
import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class StopListServiceImpl implements StopListServise {
    private final SubcategoryRepo subcategoryRepo;
    @Override
    public StopList saveStopList(String reason, Long menuItemId, Long userId) {
        return null;
    }

    @Override
    public List<StopListResponse> getAllStopList() {
        return List.of();
    }

    @Override
    public SimpleResponse updateStopListById(Long id, StopListRequest stopListRequest) {
        return null;
    }

    @Override
    public SimpleResponse deleteStopListById(Long id) {
        return null;
    }
}
