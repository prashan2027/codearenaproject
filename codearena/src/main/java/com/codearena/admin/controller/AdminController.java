package com.codearena.admin.controller;

import com.codearena.admin.service.AdminProblemService;
import com.codearena.problems.dto.ProblemListDto;
import com.codearena.problems.dto.ProblemRequestDto;
import com.codearena.problems.dto.ProblemResponseDto;
import com.codearena.problems.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminProblemService service;

//    # 1. add new problems
    @PostMapping("/addproblem")
    public ResponseEntity<ProblemResponseDto> addproblem(@RequestBody ProblemRequestDto problem){

        return ResponseEntity.ok(service.addproblem(problem));
    }
//    # 2. get problem lists
    @GetMapping("/getproblems")
    public ResponseEntity<List<ProblemListDto>> getproblemList(){
     return ResponseEntity.ok(service.getproblemlist());
    }

//    # 3. get the problem by id
    @GetMapping("/problem/{id}")
    public ResponseEntity<ProblemResponseDto> getproblem(@PathVariable Long id){
      return ResponseEntity.ok(service.getproblem(id));
    }

//    # 4. delete problem by id
    @DeleteMapping("/deleteproblem/{id}")
    public ResponseEntity<?> deleteproblem(@PathVariable Long id){
       service.deleteproblem(id);
       return ResponseEntity.ok().build();
    }

//    # 5. update problem by id
    @PutMapping("/updateproblem/{id}")
    public ResponseEntity<ProblemResponseDto> updateproblem(@PathVariable Long id,@RequestBody ProblemRequestDto problem){
   return ResponseEntity.ok(service.updateproblem(id,problem));

    }

//    update the test cases by problem id;

//    public ResponseEntity<?> updatetestcase(@RequestBody )

}
