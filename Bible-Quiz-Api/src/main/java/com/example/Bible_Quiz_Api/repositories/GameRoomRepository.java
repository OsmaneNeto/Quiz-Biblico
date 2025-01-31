package com.example.Bible_Quiz_Api.repositories;

import com.example.Bible_Quiz_Api.models.GameRoomModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRoomRepository extends JpaRepository<GameRoomModel, Long> {
    GameRoomModel findByRoomCode(String roomCode);
}
