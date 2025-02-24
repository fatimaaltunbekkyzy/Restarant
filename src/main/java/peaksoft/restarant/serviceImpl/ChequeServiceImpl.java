package peaksoft.restarant.serviceImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.restarant.dto.*;
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
                .message("Cheque saved")
                .build();
    }

    @Override
    public List<ChequeResponse> getAllCheques() {
        return chequeRepo.getAllCheques();
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
    }



























































    //        List<Cheque> cheques = chequeRepo.findAll();
//
//        // Чекти кайра түзүп жооп кылып кайтарыңыз
//        List<ChequeResponse2> chequeResponses = new ArrayList<>();
//
//        for (Cheque cheque : cheques) {
//            double totalAmount = cheque.getMenuItems().stream()
//                    .mapToDouble(MenuItem::getPrice)
//                    .sum();
//            double grandTotal = totalAmount + (totalAmount * SERVICE_PERCENTAGE / 100);
//
//            ChequeResponse2 response = ChequeResponse2.builder()
//                    .waiterFullName(cheque.getUser().getFullName()) // Официанттын аты-жөнү
//                    .menuItems(cheque.getMenuItems().stream().map(MenuItem::getName).collect(Collectors.toList())) // Меню Items
//                    .averagePrice(cheque.getPriceAverage()) // Орточо баа
//                    .servicePercentage(SERVICE_PERCENTAGE) // Кызмат акынын пайызы
//                    .grandTotal(grandTotal) // Жалпы сумма (кызмат акысы кошулду)
//                    .build();
//
//            chequeResponses.add(response);
//        }
//
//        return chequeResponses;
}