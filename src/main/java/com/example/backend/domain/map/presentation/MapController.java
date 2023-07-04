package com.example.backend.domain.map.presentation;

import com.example.backend.domain.map.presentation.dto.request.MapAddRequest;
import com.example.backend.domain.map.service.MapAddService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/map")
public class MapController {

    private final MapAddService mapAddService;

    @PostMapping
    public void mapAdd(@RequestBody @Valid MapAddRequest request){
        mapAddService.addMap(request);
    }
}
