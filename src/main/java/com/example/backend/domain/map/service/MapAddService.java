package com.example.backend.domain.map.service;

import com.example.backend.domain.map.domain.Map;
import com.example.backend.domain.map.domain.repository.MapRepository;
import com.example.backend.domain.map.presentation.dto.request.MapAddRequest;
import com.example.backend.domain.user.domain.User;
import com.example.backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MapAddService {

    private final MapRepository mapRepository;
    private final UserFacade userFacade;

    public void addMap(MapAddRequest request){

        User user = userFacade.getCurrentUser();

        mapRepository.save(
                Map.builder()
                        .longitude(request.getLongitude())
                        .latitude(request.getLatitude())
                        .installation(request.getInstallation())
                        .availability(request.getAvailability())
                        .sortation(request.getSortation())
                        .writer(user.getNickName())
                        .build());
    }
}
