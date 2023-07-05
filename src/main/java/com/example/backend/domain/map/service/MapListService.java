package com.example.backend.domain.map.service;

import com.example.backend.domain.map.domain.Map;
import com.example.backend.domain.map.facade.MapFacade;
import com.example.backend.domain.map.presentation.dto.response.MapListResponse;
import com.example.backend.domain.user.domain.User;
import com.example.backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MapListService {

    private final MapFacade mapFacade;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public MapListResponse mapList(Long mapId){

        User user = userFacade.getCurrentUser();
        Map map = mapFacade.findMapById(mapId);

        return MapListResponse.builder()
                .longitude(map.getLongitude())
                .installation(map.getInstallation())
                .availability(map.getAvailability())
                .sortation(map.getSortation())
                .latitude(map.getLatitude())
                .writer(map.getWriter())
                .date(map.getCreatedAt())
                .build();
    }
}
