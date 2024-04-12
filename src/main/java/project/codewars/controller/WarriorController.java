package project.codewars.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.codewars.DTO.Solution.SolutionRequest;
import project.codewars.Repositories.WarriorRepository;
import project.codewars.Service.WarriorService;

@RestController
@AllArgsConstructor
public class WarriorController {

    private final WarriorRepository warriorRepository;
    private final WarriorService warriorService;

    @PostMapping("/submission/{taskId}")
    public void kata_submission(@PathVariable Long taskId, @RequestParam SolutionRequest solutionRequest) {
        warriorService.kata_submission(taskId, solutionRequest);
    }
}
