package com.example.backend.domain.user.service;

import com.example.backend.domain.user.domain.repository.UserRepository;
import com.example.backend.domain.user.facade.UserFacade;
import com.example.backend.domain.user.presentation.dto.request.CodeRequest;
import com.example.backend.global.error.ErrorCode;
import com.example.backend.global.error.exeception.CustomException;
import com.example.backend.infrastructure.mail.entity.Mail;
import com.example.backend.infrastructure.mail.repository.CodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CodeService {
    private final CodeRepository codeRepository;

    @Transactional
    public boolean execute(CodeRequest request) {
        Mail mail = codeRepository.findMailByEmail(request.getEmail())
                .orElseThrow(() -> new CustomException(ErrorCode.CODE_NOT_FOUND));

        if (!mail.getValue().equals(request.getCode())) {
            throw new CustomException(ErrorCode.CODE_MISS_MATCHED);
        }else return true;
    }
}
