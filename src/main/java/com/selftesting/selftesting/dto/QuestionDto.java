package com.selftesting.selftesting.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuestionDto {
    Short type;
    String comment;
    String question;
    List<AnswerDto> answers;
    String ranswer;
    Short points;
}
