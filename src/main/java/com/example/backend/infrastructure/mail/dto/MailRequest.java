package com.example.backend.infrastructure.mail.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MailRequest {
    private String email;
}
