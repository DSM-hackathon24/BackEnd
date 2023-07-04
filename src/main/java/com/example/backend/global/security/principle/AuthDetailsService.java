package com.example.backend.global.security.principle;

import com.example.backend.domain.user.domain.User;
import com.example.backend.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String accountId) throws UsernameNotFoundException {
        User user = userRepository.findUserByAccountId(accountId)
                .orElseThrow(() -> new UsernameNotFoundException("아이디를 찾을 수 없습니다."));
        return new AuthDetails(user);
    }
}
