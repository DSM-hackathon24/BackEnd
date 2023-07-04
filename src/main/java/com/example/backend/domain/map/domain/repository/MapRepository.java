package com.example.backend.domain.map.domain.repository;

import com.example.backend.domain.map.domain.Map;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapRepository extends JpaRepository<Map, Long> {
}
