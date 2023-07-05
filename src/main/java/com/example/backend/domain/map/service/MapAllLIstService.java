package com.example.backend.domain.map.service;

import com.example.backend.domain.comment.presentation.dto.response.CommentListResponse;
import com.example.backend.domain.map.domain.Map;
import com.example.backend.domain.map.domain.repository.MapRepository;
import com.example.backend.domain.map.presentation.dto.response.MapAllListResponse;
import com.example.backend.domain.map.presentation.dto.response.MapListResponse;
import com.example.backend.domain.user.domain.User;
import com.example.backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MapAllLIstService {

    private final MapRepository mapRepository;
    private final UserFacade userFacade;

    public List<MapAllListResponse> mapAllList() {

        User user = userFacade.getCurrentUser();

        List<Map> maps = mapRepository.findAll();

        return maps.stream()
                .map(map -> MapAllListResponse.builder()
                        .mapId(map.getId())
                        .latitude(map.getLatitude())
                        .longitude(map.getLongitude())
                        .sortation(map.getSortation())
                        .build())
                .toList();
    }
}
