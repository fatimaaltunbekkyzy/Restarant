package peaksoft.restarant.service;

import peaksoft.restarant.dto.SimpleResponse;
import peaksoft.restarant.dto.StopListRequest;
import peaksoft.restarant.dto.StopListResponse;
import peaksoft.restarant.entities.StopList;

import java.util.List;

public interface StopListServise {

    SimpleResponse saveStopList(StopListRequest stopListRequest);

    List<StopListResponse> getAllStopList();


    SimpleResponse deleteStopListById(Long id);
}
