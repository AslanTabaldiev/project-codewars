package project.codewars.Service.UserServiceImpl;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import project.codewars.DTO.Tasks.TasksRequest;
import project.codewars.Repositories.StatsRepository;
import project.codewars.Repositories.TasksRepository;
import project.codewars.Service.TasksService;
import project.codewars.entity.Stats;
import project.codewars.entity.Tasks;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class TasksServiceImpl implements TasksService {

    private final TasksRepository tasksRepository;
    private final StatsRepository statsRepository;

    @Override
    public void addtask(TasksRequest tasksRequest, String token) {
        if(tasksRepository.findByName(tasksRequest.getName()).isPresent()) {
            throw new BadCredentialsException("Task with this name is already exist");
        }
        Tasks task = new Tasks();
        task.setName(tasksRequest.getName());
        task.setDescription(tasksRequest.getDescription());
        task.setRight_solution(tasksRequest.getRight_solution());
        task.setRank(tasksRequest.getRank());
        task.setTask_points(tasksRequest.getTask_points());
        task.setCompletion_times(0);
        task.setBookmark(0);

        tasksRepository.save(task);

        Stats stats = new Stats();
        stats.setCreated_date(LocalDate.now().toString());
        stats.setPublished_date(LocalDate.now().toString());
        stats.setWarriors_trained(0);

        task.setStats(stats);

        statsRepository.save(stats);
    }
}
