package com.example.backend.infrastructure.mail.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@RedisHash(value = "EmailCode")
public class Mail {
    @Id
    @Indexed
    private String email;

    @NotBlank
    private String value;

    @TimeToLive
    private Long codeTime;

}
