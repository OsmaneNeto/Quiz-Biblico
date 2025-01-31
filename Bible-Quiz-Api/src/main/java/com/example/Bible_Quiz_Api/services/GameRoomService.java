package com.example.Bible_Quiz_Api.services;

import com.example.Bible_Quiz_Api.models.GameRoomModel;
import com.example.Bible_Quiz_Api.models.GameStatus;
import com.example.Bible_Quiz_Api.models.QuestionModel;
import com.example.Bible_Quiz_Api.repositories.GameRoomRepository;
import com.example.Bible_Quiz_Api.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameRoomService {

    @Autowired
    private GameRoomRepository gameRoomRepository;

    @Autowired
    private QuestionRepository questionRepository;


    // Criar uma nova sala de jogo
    public GameRoomModel createGameRoom(String roomName, List<Long> questionIds) {
        // Agora estamos buscando uma lista de QuestionModel, não TypePatternQuestions.Question
        List<QuestionModel> questions = questionRepository.findAllById(questionIds);



        GameRoomModel gameRoom = new GameRoomModel();
        gameRoom.setRoomName(roomName);
        gameRoom.setRoomCode(generateRoomCode());
        gameRoom.setQuestions(questions);  // Agora 'questions' é uma lista de QuestionModel
        gameRoom.setGameStatus(GameStatus.valueOf("IN_PROGRESS"));

        // Salvar o objeto GameRoomModel no banco de dados
        gameRoomRepository.save(gameRoom);

        return gameRoom;
    }



    // Adicionar um jogador à sala
    public String addPlayerToRoom(String roomCode, String playerName) {
        GameRoomModel gameRoom = gameRoomRepository.findByRoomCode(roomCode);
        if (gameRoom != null && gameRoom.getGameStatus().equals("IN_PROGRESS")) {
            gameRoom.getPlayers().add(playerName);
            gameRoomRepository.save(gameRoom);  // Aqui
            return "Jogador " + playerName + " entrou na sala com sucesso!";
        } else {
            return "Sala não encontrada ou já finalizada.";
        }
    }


    // Verificar se a resposta do quiz está correta
    public String checkQuizAnswer(String playerAnswer, QuestionModel question) {
        if (question == null || playerAnswer == null) {
            return "Pergunta ou resposta inválida.";
        }

        if (question.getCorrectAnswer().equalsIgnoreCase(playerAnswer.trim())) {
            return "Resposta correta!";
        } else {
            return "Resposta incorreta. A resposta correta é: " + question.getCorrectAnswer();
        }
    }


    // Gerar um código aleatório para a sala
    private String generateRoomCode() {
        return java.util.UUID.randomUUID().toString().substring(0, 6).toUpperCase();
    }

    // Buscar sala por código
    public GameRoomModel getRoomByCode(String roomCode) {
        return gameRoomRepository.findByRoomCode(roomCode);
    }
}
