package peaksoft.restarant.service;

import peaksoft.restarant.dto.ChequeRequest;
import peaksoft.restarant.dto.ChequeResponse;
import peaksoft.restarant.dto.RestaurantResponse;
import peaksoft.restarant.dto.SimpleResponse;

import java.util.List;

public interface ChequeService {
    SimpleResponse saveCheque(ChequeRequest chequeRequest);

    List<ChequeResponse> getAllCheques();

    SimpleResponse deleteChequeById(Long id);

}
