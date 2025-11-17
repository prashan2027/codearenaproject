package com.codearena.problems.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProblemListDto {
    private Long id;
    private String title;
    private String difficulty;
    private List<String> tag;
    private List<String> company;
}
