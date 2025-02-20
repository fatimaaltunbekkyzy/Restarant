package peaksoft.restarant.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.restarant.dto.ChequeRequest;
import peaksoft.restarant.dto.RestaurantResponse;
import peaksoft.restarant.dto.SimpleResponse;
import peaksoft.restarant.entities.Cheque;
import peaksoft.restarant.repo.ChequeRepo;
import peaksoft.restarant.service.ChequeService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ChequeServiceImpl implements ChequeService {
    private final ChequeRepo chequeRepo;
    @Override
    public SimpleResponse saveCheque(ChequeRequest chequeRequest) {
        Cheque cheque = new Cheque();
        cheque.setPriceAverage(chequeRequest.getPriceAverage());
        cheque.setCreatedAt(chequeRequest.getCreatedAt());
        chequeRepo.save(cheque);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("subcategory saved")
                .build();
    }

    @Override
    public List<RestaurantResponse> getAllCheques() {
        return getAllCheques();
    }

    @Override
    public SimpleResponse deleteChequeById(Long id) {
        try {
            chequeRepo.deleteById(id);
            return SimpleResponse.builder()
                    .httpStatus(HttpStatus.OK)
                    .message("user ийгиликтүү өчүрүлдү")
                    .build();
        } catch (Exception e) {
            return SimpleResponse.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("user ди өчүрүү учурунда ката чыкты: " + e.getMessage())
                    .build();
        }
    }}
