package com.selftesting.selftesting.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Test {
    @Id
    private Integer idTest;
    private String name;
    private Integer idSubject;
    private Integer idGrade;
}
