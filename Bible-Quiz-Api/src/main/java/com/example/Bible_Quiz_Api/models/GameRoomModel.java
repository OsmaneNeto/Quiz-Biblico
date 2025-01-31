package com.example.Bible_Quiz_Api.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class GameRoomModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String roomCode;  // Código único da sala, para identificação

    @Column(nullable = false)
    private String roomName;  // Nome da sala

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GameStatus gameStatus;  // Status do jogo (por exemplo, IN_PROGRESS, FINISHED)

    @ManyToMany
    @JoinTable(
            name = "game_room_questions",
            joinColumns = @JoinColumn(name = "game_room_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<QuestionModel> questions;  // Lista de perguntas associadas à sala

    @ElementCollection
    private List<String> players;  // Lista de jogadores na sala

    // Construtor padrão
    public GameRoomModel() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<QuestionModel> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionModel> questions) {
        this.questions = questions;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }
}
