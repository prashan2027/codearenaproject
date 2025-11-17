package com.codearena.admin.controller;

import com.codearena.problems.dto.ProblemListDto;
import com.codearena.problems.dto.ProblemRequestDto;
import com.codearena.problems.dto.ProblemResponseDto;
import com.codearena.problems.service.ProblemService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final ProblemService problemService;

//    # 1. add new problems
    @PostMapping("/addproblem")
    public ResponseEntity<Void> addproblem(@RequestBody ProblemRequestDto problem){
        problemService.addproblem(problem);
        return ResponseEntity.ok().build();
    }
//    # 2. get problem lists
    @GetMapping("/getproblems")
    public ResponseEntity<List<ProblemListDto>> getproblemList(){
     return ResponseEntity.ok(problemService.getproblemlist());
    }

//    # 3. get the problem by id
    @GetMapping("/problem/{id}")
    public ResponseEntity<ProblemResponseDto> getproblem(@PathVariable Long id){
      return ResponseEntity.ok(problemService.getproblem(id));
    }

//    # 4. delete problem by id
    @DeleteMapping("/deleteproblem/{id}")
    public ResponseEntity<?> deleteproblem(@PathVariable Long id){
       problemService.deleteProblem(id);
       return ResponseEntity.ok().build();
    }

//    # 5. update problem by id
    @PutMapping("/updateproblem/{id}")
    public ResponseEntity<ProblemResponseDto> updateproblem(@PathVariable Long id,@RequestBody ProblemRequestDto problem){

    }

//    update the test cases by problem id;

//    public ResponseEntity<?> updatetestcase(@RequestBody )

}
