package com.example.backend.domain.user.facade;

import com.example.backend.domain.user.domain.User;
import com.example.backend.domain.user.domain.repository.UserRepository;
import com.example.backend.global.error.ErrorCode;
import com.example.backend.global.error.exeception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {
    private final UserRepository userRepository;

    public User getCurrentUser() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByAccountId(accountId);
    }

    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

    }
    public User getUserByAccountId(String accountId) {
        return userRepository.findUserByAccountId(accountId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
    }

    public void existsByAccountId(String accountId){
        if(userRepository.existsByAccountId(accountId)){
            throw new CustomException(ErrorCode.EXIST_USER);
        }
    }
}
