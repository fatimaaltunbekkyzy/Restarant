package peaksoft.restarant.service;

import peaksoft.restarant.dto.SimpleResponse;
import peaksoft.restarant.dto.StopListRequest;
import peaksoft.restarant.dto.StopListResponse;
import peaksoft.restarant.entities.StopList;

import java.util.List;

public interface StopListServise {

    StopList saveStopList(String reason, Long menuItemId, Long userId);

    List<StopListResponse> getAllStopList();

    SimpleResponse updateStopListById(Long id, StopListRequest stopListRequest);

    SimpleResponse deleteStopListById(Long id);
}
