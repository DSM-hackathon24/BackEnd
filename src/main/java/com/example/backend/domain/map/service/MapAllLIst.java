package com.example.backend.domain.map.service;

import com.example.backend.domain.map.presentation.dto.response.MapListResponse;
import com.example.backend.domain.user.domain.User;
import com.example.backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MapAllLIst {

    private final UserFacade userFacade;

    public MapListResponse mapAllList(){

        User user = userFacade.getCurrentUser();

        return MapListResponse.builder()
                .longitude(mapAllList().getLongitude())
                .latitude(mapAllList().getLatitude())
                .availability(mapAllList().getAvailability())
                .installation(mapAllList().getInstallation())
                .sortation(mapAllList().getSortation())
                .writer(user.getNickName())
                .build();
    }
}
