package com.example.backend.domain.board.domain.repository;

import com.example.backend.domain.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<Board> findBoardById(Long id);
}
