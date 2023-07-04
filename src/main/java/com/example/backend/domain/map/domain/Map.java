package com.example.backend.domain.map.domain;

import com.example.backend.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Table(name = "map")
public class Map extends BaseEntity {

    @NotNull
    private Double longitude;

    @NotNull
    private Double latitude;

    @NotNull
    private Boolean availability = false;

    @NotBlank
    private String sortation;

    @NotBlank
    private String installation;

    @Builder
    public Map(Double longitude, Double latitude, Boolean availability, String sortation, String installation){
        this.longitude = longitude;
        this.latitude = latitude;
        this.availability = availability;
        this.sortation = sortation;
        this.installation = installation;
    }
}
