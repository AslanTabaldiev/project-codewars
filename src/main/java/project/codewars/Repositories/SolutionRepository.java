package project.codewars.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.codewars.entity.Solution;

public interface SolutionRepository extends JpaRepository<Solution, Long> {
}
