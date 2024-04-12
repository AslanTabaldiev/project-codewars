package project.codewars.Service;

import project.codewars.DTO.Solution.SolutionRequest;

public interface WarriorService {

    void kata_submission(Long taskId, SolutionRequest solutionRequest);
}
