package com.codearena.admin.controller;

import com.codearena.problems.dto.ProblemListDto;
import com.codearena.problems.dto.ProblemRequestDto;
import com.codearena.problems.dto.ProblemResponseDto;
import com.codearena.problems.service.ProblemService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

//    # 1. add new problems
    @PostMapping("/addproblem")
    public ResponseEntity<Void> addproblem(@RequestBody ProblemRequestDto problem){

    }
//    # 2. get problem lists
    @GetMapping("/getproblems")
    public ResponseEntity<ProblemListDto> getproblemList(){

    }

//    # 3. get the problem by id
    @GetMapping("/problem/{id}")
    public ResponseEntity<ProblemResponseDto> getproblem(@PathVariable Long id){

    }

//    # 4. delete problem by id
    @DeleteMapping("/deleteproblem/{id}")
    public ResponseEntity<Void> deleteproblem(@PathVariable Long id){


    }

//    # 5. update problem by id
    @PutMapping("/updateproblem/{id}")
    public ResponseEntity<ProblemResponseDto> updateproblem(@PathVariable Long id,@RequestBody ProblemRequestDto problem){

    }






}
