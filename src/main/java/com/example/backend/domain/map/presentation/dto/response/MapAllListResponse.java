package com.example.backend.domain.map.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MapAllListResponse {

    private Long mapId;

    private Double longitude;

    private Double latitude;
}
