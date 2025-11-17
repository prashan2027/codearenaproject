package com.codearena.problems.dto;

import com.codearena.problems.entity.TestCase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProblemRequestDto{

    private String title;
    private String description;
    private String inputformat;
    private String outputformat;
    private String difficulty;
    private String constraints;
    private List<String> tags;
    private List<String> company;
    private List<TestCaseDto> testcases;

}
