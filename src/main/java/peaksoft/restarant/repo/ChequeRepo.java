package peaksoft.restarant.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.restarant.dto.ChequeResponse;
import peaksoft.restarant.entities.Cheque;
import java.util.List;

@Repository
public interface ChequeRepo extends JpaRepository<Cheque, Long> {
    @Query("select new peaksoft.restarant.dto.ChequeResponse(c.id,c.priceAverage,c.createdAt)from Cheque c")
    List<ChequeResponse> getAllCheques();
}
