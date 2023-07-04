package com.example.backend.domain.map.domain;

import com.example.backend.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Table(name = "map")
public class Map extends BaseEntity {

    @NotBlank
    private Double longitude;

    @NotBlank
    private Double latitude;

    @NotBlank
    private Boolean availability;

    @NotBlank
    private String sortation;

    @NotBlank
    private String installation;

    public Map(Double longitude, Double latitude, Boolean availability, String sortation, String installation){
        this.longitude = longitude;
        this.latitude = latitude;
        this.availability = availability;
        this.sortation = sortation;
        this.installation = installation;
    }
}
