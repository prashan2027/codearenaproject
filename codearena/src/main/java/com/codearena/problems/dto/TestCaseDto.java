package com.codearena.problems.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCaseDto {

    private String input;

    private String output;

    private Boolean ishidden;
}
