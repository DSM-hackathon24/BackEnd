package com.example.backend.domain.map.domain;

import com.example.backend.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Table(name = "map")
public class Map extends BaseEntity {

    private Integer longitude;

    private Integer latitude;

    private Boolean Availability;

}
