package com.example.backend.domain.map.domain;

import com.example.backend.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Table(name = "map")
public class Map extends BaseEntity {

    private Double longitude;

    private Double latitude;

    private Boolean availability = false;

    private String sortation;

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
