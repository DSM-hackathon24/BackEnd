package com.example.backend.infrastructure.mail.repository;

import com.example.backend.infrastructure.mail.entity.Mail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CodeRepository extends CrudRepository<Mail, String> {
    Optional<Mail> findMailByEmail(String email);
}
