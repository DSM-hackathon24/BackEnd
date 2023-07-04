package com.example.backend.domain.board.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {

    Tips("TIP", "안전 수칙"),
    Products("PRODUCTS", "안전 제품"),
    Information("INFORMATION", "심심 탈출 넘버원");

    private final String name;

    private final String title;
}
