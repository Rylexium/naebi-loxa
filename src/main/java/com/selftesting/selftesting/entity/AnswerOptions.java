package com.selftesting.selftesting.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AnswerOptions {
    @Id
    Short idAnswer;
    Short idQuestion;
    String answer;
}
