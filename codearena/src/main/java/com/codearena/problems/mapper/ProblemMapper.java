package com.codearena.problems.mapper;

import com.codearena.problems.dto.ProblemRequestDto;
import com.codearena.problems.dto.ProblemResponseDto;
import com.codearena.problems.dto.TestCaseDto;
import com.codearena.problems.entity.Problem;
import com.codearena.problems.entity.TestCase;

import java.time.LocalDateTime;
import java.util.Date;

public class ProblemMapper {

    public static ProblemResponseDto todto(Problem problem){
        ProblemResponseDto dto=new ProblemResponseDto();

        dto.setId(problem.getId());
        dto.setTitle(problem.getTitle());
        dto.setDescription(problem.getDescription());
        dto.setInputformat(problem.getInputformat());
        dto.setOutputformat(problem.getOutputformat());
        dto.setDifficulty(problem.getDifficulty());
        dto.setConstraints(problem.getConstraints());
        dto.setCompany(problem.getCompany());
        dto.setTags(problem.getTags());
        dto.setTestcases(problem.getTestCases().stream().map(ProblemMapper::totestcasedto).toList());
        return dto;
    }

    public static  Problem toproblem(ProblemRequestDto dto){
        Problem problem=new Problem();
        problem.setTitle(dto.getTitle());
        problem.setDescription(dto.getDescription());
        problem.setInputformat(dto.getInputformat());
        problem.setOutputformat(dto.getOutputformat());
        problem.setDifficulty(dto.getDifficulty());
        problem.setConstraints(dto.getConstraints());
        problem.setCompany(dto.getCompany());
        problem.setTags(dto.getTags());
        problem.setCreatedat(new Date());
        return problem;
    }

    public static TestCaseDto totestcasedto(TestCase testCase){
        TestCaseDto dto=new TestCaseDto();
        dto.setInput(testCase.getInput());
        dto.setOutput(testCase.getOutput());
        dto.setIshidden(testCase.getHidden());
        return dto;
    }

    public static TestCase totestcase(TestCaseDto dto,Problem problem){
        TestCase testcase=new TestCase();
        testcase.setInput(dto.getInput());
        testcase.setOutput(dto.getOutput());
        testcase.setHidden(dto.getIshidden());
        testcase.setProblem(problem);
        return testcase;
    }

}
