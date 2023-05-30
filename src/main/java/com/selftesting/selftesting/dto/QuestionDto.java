package com.selftesting.selftesting.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuestionDto {
    Short type;
    String comment;
    Integer question;
    List<String> answers;
    String ranswer;
    Short points;
}
