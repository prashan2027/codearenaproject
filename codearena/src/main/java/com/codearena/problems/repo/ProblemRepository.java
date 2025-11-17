package com.codearena.problems.repo;

import com.codearena.problems.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<Problem,Long> {

}
