package peaksoft.restarant.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.restarant.dto.StopListResponse;
import peaksoft.restarant.entities.StopList;

import java.util.List;

@Repository
public interface StopListRepo extends JpaRepository<StopList, Long> {
    @Query("select new peaksoft.restarant.dto.StopListResponse(s.id,s.reason,s.date)from StopList s")
    List<StopListResponse> getAllStopList();
}
