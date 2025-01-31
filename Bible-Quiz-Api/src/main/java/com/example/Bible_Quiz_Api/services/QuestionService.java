package com.example.Bible_Quiz_Api.services;

import com.example.Bible_Quiz_Api.models.QuestionModel;
import com.example.Bible_Quiz_Api.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    // Criar uma nova pergunta
    public QuestionModel createQuestion(QuestionModel question) {
        return questionRepository.save(question);
    }

    // Buscar todas as perguntas
    public List<QuestionModel> getAllQuestions() {
        return questionRepository.findAll();
    }

    // Buscar uma pergunta pelo ID
    public Optional<QuestionModel> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    // Verificar se a resposta está correta
    public boolean isAnswerCorrect(Long questionId, String playerAnswer) {
        Optional<QuestionModel> question = questionRepository.findById(questionId);
        return question.isPresent() && question.get().getCorrectAnswer().equalsIgnoreCase(playerAnswer);
    }
}
