package project.codewars.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.codewars.DTO.Solution.SolutionRequest;
import project.codewars.Repositories.WarriorRepository;

@RestController
@AllArgsConstructor
public class WarriorController {

    private final WarriorRepository warriorRepository;

    @PostMapping("/submission")
    public void kata_submission(@PathVariable Long taskId, @RequestParam SolutionRequest solutionRequest) {

    }
}
