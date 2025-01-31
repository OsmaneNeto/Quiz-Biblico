package com.example.Bible_Quiz_Api.controllers;

import com.example.Bible_Quiz_Api.models.GameRoomModel;
import com.example.Bible_Quiz_Api.models.QuestionModel;
import com.example.Bible_Quiz_Api.services.GameRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameController {

    @Autowired
    private GameRoomService gameRoomService;

    // Criar uma nova sala de jogo
    @PostMapping("/create")
    public ResponseEntity<GameRoomModel> createRoom(@RequestParam String roomName, @RequestParam List<Long> questionIds) {
        if (roomName == null || roomName.isEmpty()) {
            return ResponseEntity.badRequest().body(null); // Retorna erro caso o nome da sala seja vazio
        }

        if (questionIds == null || questionIds.isEmpty()) {
            return ResponseEntity.badRequest().body(null); // Retorna erro caso a lista de perguntas esteja vazia
        }

        try {
            GameRoomModel gameRoom = gameRoomService.createGameRoom(roomName, questionIds);
            if (gameRoom != null) {
                return ResponseEntity.ok(gameRoom); // Retorna a sala criada
            } else {
                return ResponseEntity.status(500).body(null); // Erro inesperado no servidor
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null); // Erro inesperado no servidor
        }
    }

    // Entrar em uma sala
    @PostMapping("/join")
    public ResponseEntity<String> joinRoom(@RequestParam String roomCode, @RequestParam String playerName) {
        if (roomCode == null || roomCode.isEmpty() || playerName == null || playerName.isEmpty()) {
            return ResponseEntity.badRequest().body("Parâmetros inválidos: 'roomCode' ou 'playerName' estão ausentes.");
        }

        try {
            String message = gameRoomService.addPlayerToRoom(roomCode, playerName);
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao tentar entrar na sala.");
        }
    }

    // Submeter uma resposta para uma pergunta
    @PostMapping("/submitAnswer")
    public ResponseEntity<String> submitAnswer(@RequestParam String roomCode, @RequestParam String playerName, @RequestParam String playerAnswer) {
        if (roomCode == null || roomCode.isEmpty() || playerName == null || playerName.isEmpty() || playerAnswer == null || playerAnswer.isEmpty()) {
            return ResponseEntity.badRequest().body("Parâmetros inválidos: 'roomCode', 'playerName' ou 'playerAnswer' estão ausentes.");
        }

        try {
            GameRoomModel gameRoom = gameRoomService.getRoomByCode(roomCode);
            if (gameRoom != null && !gameRoom.getQuestions().isEmpty()) {
                QuestionModel currentQuestion = gameRoom.getQuestions().get(0); // Pegando a primeira pergunta
                String result = gameRoomService.checkQuizAnswer(playerAnswer, currentQuestion);
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.badRequest().body("Sala ou pergunta não encontrada.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao submeter a resposta.");
        }
    }
}
