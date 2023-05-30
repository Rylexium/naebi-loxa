package com.selftesting.selftesting.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerDto {
    short idAnswer;
    String answer;
}
