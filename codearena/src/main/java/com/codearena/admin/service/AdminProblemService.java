package com.codearena.admin.service;

import com.codearena.problems.dto.ProblemListDto;
import com.codearena.problems.dto.ProblemRequestDto;
import com.codearena.problems.dto.ProblemResponseDto;
import com.codearena.problems.dto.TestCaseDto;
import com.codearena.problems.entity.Problem;
import com.codearena.problems.entity.TestCase;
import com.codearena.problems.mapper.ProblemMapper;
import com.codearena.problems.repo.ProblemRepository;
import com.codearena.problems.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminProblemService {

    private final ProblemRepository problemRepository;

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
    
//    get the problem by id 
    public ProblemResponseDto getproblem(Long id){
        try{
            Problem problem=problemRepository.findById(id).orElseThrow(()->new RuntimeException("problem not found"));
            return ProblemMapper.todto(problem);
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

   public  void deleteproblem(Long id){
        try{
            Problem problem=problemRepository.findById(id).orElseThrow(()->new RuntimeException("problem not found"));
            problemRepository.delete(problem);
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public ProblemResponseDto updateproblem(Long id,ProblemRequestDto requestDto){
                try {
                    Problem problem=problemRepository.findById(id).orElseThrow(()->new RuntimeException("Problem not found"));
                    problem.setTitle(requestDto.getTitle());
                    problem.setDescription(requestDto.getDescription());
                    problem.setDifficulty(requestDto.getDifficulty());
                    problem.setCompany(requestDto.getCompany());
                    problem.setInputformat(requestDto.getInputformat());
                    problem.setOutputformat(requestDto.getOutputformat());
                    problem.setConstraints(requestDto.getConstraints());
                    problem.setCreatedat(new Date());
                    problem.setTags(requestDto.getTags());
                    problemRepository.save(problem);
                    return ProblemMapper.todto(problem);
                }catch (Exception e){
                    throw new RuntimeException(e.getMessage());
                }


    }




}
