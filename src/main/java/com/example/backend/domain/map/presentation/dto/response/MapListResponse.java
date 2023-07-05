package com.example.backend.domain.map.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class MapListResponse {

    private Double longitude;

    private Double latitude;

    private Boolean availability;

    private String sortation;

    private String installation;

    private String writer;

    private LocalDate date;
}
