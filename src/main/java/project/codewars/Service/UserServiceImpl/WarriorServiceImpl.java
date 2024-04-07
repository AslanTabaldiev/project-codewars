package project.codewars.Service.UserServiceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.codewars.DTO.Solution.SolutionRequest;
import project.codewars.Repositories.TasksRepository;
import project.codewars.Service.WarriorService;

@Service
@AllArgsConstructor
public class WarriorServiceImpl implements WarriorService {

    private final TasksRepository tasksRepository;

    public void kata_submission(SolutionRequest solutionRequest) {

    }
}
