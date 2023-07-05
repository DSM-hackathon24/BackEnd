package com.example.backend.domain.map.presentation;

import com.example.backend.domain.map.presentation.dto.request.MapAddRequest;
import com.example.backend.domain.map.presentation.dto.response.MapListResponse;
import com.example.backend.domain.map.service.MapAddService;
import com.example.backend.domain.map.service.MapListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Map", description = "Map API 입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/map")
public class MapController {

    private final MapAddService mapAddService;
    private final MapListService mapListService;

    @Operation(summary = "소화전 장소 저장")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void mapAdd(@RequestBody @Valid MapAddRequest request){
        mapAddService.addMap(request);
    }

    @Operation(summary = "소화전 장소 조회")
    @GetMapping("/list/{mapId}")
    public MapListResponse mapList(@PathVariable Long mapId){
        return mapListService.mapList(mapId);
    }
}
