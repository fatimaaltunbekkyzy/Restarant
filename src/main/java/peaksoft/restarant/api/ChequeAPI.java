package peaksoft.restarant.api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import peaksoft.restarant.dto.ChequeRequest;
import peaksoft.restarant.dto.ChequeResponse;
import peaksoft.restarant.dto.SimpleResponse;
import peaksoft.restarant.service.ChequeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/cheques")
public class ChequeAPI {
    private final ChequeService chequeService;

//     CRUD METHODS Cheque
    @PostMapping
    public SimpleResponse saveUser(@RequestBody ChequeRequest chequeRequest) {
        return chequeService.saveCheque(chequeRequest);
    }
    @GetMapping
    List<ChequeResponse> gerAll() {
        return null;
    }
    @DeleteMapping("/{id}")
    public SimpleResponse deleteRestaurantById(@PathVariable Long id) {
        return chequeService.deleteChequeById(id);
}}
