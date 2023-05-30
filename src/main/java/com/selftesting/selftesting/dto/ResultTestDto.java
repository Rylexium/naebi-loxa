package com.selftesting.selftesting.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultTestDto {
    String name;
    String score;
}
