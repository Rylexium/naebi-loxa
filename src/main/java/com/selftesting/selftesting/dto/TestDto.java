package com.selftesting.selftesting.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestDto {
    Integer id;
    String name;
}
