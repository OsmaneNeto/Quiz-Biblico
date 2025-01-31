package com.example.Bible_Quiz_Api.repositories;

import com.example.Bible_Quiz_Api.models.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuestionModel, Long> {
}
