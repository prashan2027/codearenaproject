package com.codearena.problems.service;

import com.codearena.problems.dto.ProblemListDto;
import com.codearena.problems.dto.ProblemRequestDto;
import com.codearena.problems.dto.ProblemResponseDto;
import com.codearena.problems.dto.TestCaseDto;
import com.codearena.problems.entity.Problem;
import com.codearena.problems.entity.TestCase;
import com.codearena.problems.mapper.ProblemMapper;
import com.codearena.problems.repo.ProblemRepository;
import com.codearena.problems.repo.TestCaseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProblemService {

    private final ProblemRepository problemRepository;

    private final TestCaseRepo testcaserepo;

    public void addproblem(ProblemRequestDto requestDto) {
        try {
            Problem problem = ProblemMapper.toproblem(requestDto);

            List<TestCase> testcases = new ArrayList<TestCase>();

            Integer num = 1;
            for (TestCaseDto test : requestDto.getTestcases()) {
                TestCase testcase = new TestCase();
                testcase.setProblem(problem);
                testcase.setInput(test.getInput());
                testcase.setOutput(test.getOutput());
                testcase.setExpectedError("False");
                testcase.setHidden(test.getIshidden());
                testcase.setCreatedAt(LocalDateTime.now());
                testcase.setSerialNumber(num++);
                testcases.add(testcase);
            }
            problem.setTestCases(testcases);
            problemRepository.save(problem);


        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    //get all  problems
    public List<ProblemResponseDto> getproblems() {
        try {
            List<Problem> problem = problemRepository.findAll();
            List<ProblemResponseDto> dtolist = new ArrayList<ProblemResponseDto>();

            for (Problem p : problem) {
                ProblemResponseDto responseDto = new ProblemResponseDto();
                responseDto.setId(p.getId());
                responseDto.setTitle(p.getTitle());
                responseDto.setDescription(p.getDescription());
                responseDto.setInputformat(p.getInputformat());
                responseDto.setOutputformat(p.getOutputformat());
                responseDto.setDifficulty(p.getDifficulty());
                responseDto.setConstraints(p.getConstraints());
                responseDto.setTags(p.getTags());
                responseDto.setCompany(p.getCompany());
                responseDto.setTestcases(p.getTestCases().stream().map(ProblemMapper::totestcasedto).toList());
                dtolist.add(responseDto);
            }
            return dtolist;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    //    get all problems list for listing all the problems to user
    public List<ProblemListDto> getproblemlist() {
        try {
            return problemRepository.findAll().stream()
                    .map(p -> ProblemListDto.builder()
                            .id(p.getId())
                            .title(p.getTitle())
                            .tag(p.getTags())
                            .difficulty(p.getDifficulty())
                            .company(p.getCompany())
                            .build()
                    ).toList();

        } catch (DataAccessException dae) {
            throw new RuntimeException("Problems not found");
        }
    }
//get the particular probelem from list

    public ProblemResponseDto getproblem(Long id){
        try{
            Problem problem=problemRepository.findById(id).orElseThrow(()->new RuntimeException("problem not found "));
           ProblemResponseDto dto= ProblemMapper.todto(problem);
           dto.setTestcases(problem.getTestCases().stream().map(ProblemMapper::totestcasedto).toList());
           return dto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    delete a problem by id

    public void deleteProblem(Long id){
        try{
           Problem problem= problemRepository.findById(id).orElseThrow(()->new RuntimeException("problem not found"));
           problemRepository.delete(problem);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
