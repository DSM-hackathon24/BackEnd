package com.example.backend.domain.map.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
public class MapAddRequest {

    private Double longitude;

    private Double latitude;

    private Boolean availability = false;

    private String sortation;

    private String installation;
}
