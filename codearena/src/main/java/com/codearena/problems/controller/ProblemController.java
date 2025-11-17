package com.codearena.problems.controller;


import com.codearena.problems.dto.ProblemListDto;
import com.codearena.problems.dto.ProblemRequestDto;
import com.codearena.problems.dto.ProblemResponseDto;
import com.codearena.problems.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/problem")
public class ProblemController {

    private final ProblemService problemService;

    @PostMapping("/problems")
    public ResponseEntity<?> addproblem(@RequestBody ProblemRequestDto problemRequestDto){
        problemService.addproblem(problemRequestDto);
        return ResponseEntity.ok().build();
    }
//get list of problems
    @GetMapping("/getlist")
    public ResponseEntity<List<ProblemListDto>> getlist(){
      return ResponseEntity.ok(problemService.getproblemlist());

    }

//    get the problem full data
    @GetMapping("/getproblem/:id")
    public ResponseEntity<ProblemResponseDto> getproblem(@PathVariable Long id){
        return ResponseEntity.ok(problemService.getproblem(id));
    }


    @GetMapping("/getproblem")
    public ResponseEntity<?> getproblems(){

        return ResponseEntity.ok(problemService.getproblems());
    }

    @DeleteMapping("/deleteproblem/:id")
    public ResponseEntity<?> deleteproblems(@PathVariable Long id){
        return ResponseEntity.ok().build();
    }


}
