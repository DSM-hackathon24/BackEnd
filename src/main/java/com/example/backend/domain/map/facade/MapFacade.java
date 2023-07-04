package com.example.backend.domain.map.facade;

import com.example.backend.domain.map.domain.Map;
import com.example.backend.domain.map.domain.repository.MapRepository;
import com.example.backend.global.error.ErrorCode;
import com.example.backend.global.error.exeception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MapFacade {

    private final MapRepository mapRepository;

    public Map getMapById(Long mapId){
        return mapRepository.findMap(mapId)
                .orElseThrow(() -> new CustomException(ErrorCode.CODE_NOT_FOUND));
    }
}
