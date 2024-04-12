package project.codewars.Service.UserServiceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.codewars.DTO.Solution.SolutionRequest;
import project.codewars.Repositories.TasksRepository;
import project.codewars.Service.WarriorService;
import project.codewars.entity.Solution;
import project.codewars.entity.Tasks;

import java.util.Optional;

@Service
@AllArgsConstructor
public class WarriorServiceImpl implements WarriorService {

    private final TasksRepository tasksRepository;

    public void kata_submission(Long taskId , SolutionRequest solutionRequest) {
        Optional<Tasks> tasks = tasksRepository.findById(taskId);

        if(tasks.get().getRight_solution().equals(solutionRequest.getSolution())) {
            int total_code_completed = tasks.get().getStats().getTotal_times_completed();
            //Добавляет к количеству решенных раз - 1
            tasks.get().getStats().setTotal_times_completed(total_code_completed + 1);

            Solution solution = new Solution();
            solution.setWarrior_solution(solutionRequest.getSolution());
        }
        int total_code_submission = tasks.get().getStats().getTotal_code_submission();
        tasks.get().getStats().setTotal_code_submission(total_code_submission + 1);
    }
}
