package com.example.backend.domain.user.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CodeRequest {
    private String code;
    private String email;
}
