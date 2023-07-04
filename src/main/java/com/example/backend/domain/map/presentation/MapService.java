package com.example.backend.domain.map.presentation;

import com.example.backend.domain.map.domain.repository.MapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class MapService {

    private final MapRepository mapRepository;
}
