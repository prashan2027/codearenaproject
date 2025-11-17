package com.codearena.problems.repo;

import com.codearena.problems.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCaseRepo extends JpaRepository<TestCase,Long> {

    long countByProblemId(long problemId);

}
