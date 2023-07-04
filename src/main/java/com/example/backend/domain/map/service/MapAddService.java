package com.example.backend.domain.map.service;

import com.example.backend.domain.map.domain.Map;
import com.example.backend.domain.map.domain.repository.MapRepository;
import com.example.backend.domain.map.presentation.dto.request.MapAddRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MapAddService {

    private final MapRepository mapRepository;

    public void addMap(MapAddRequest request){
        mapRepository.save(
                Map.builder()
                        .longitude(request.getLongitude())
                        .latitude(request.getLatitude())
                        .installation(request.getInstallation())
                        .availability(request.getAvailability())
                        .sortation(request.getSortation())
                        .build());
    }
}
