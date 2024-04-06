package project.codewars.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.codewars.DTO.Tasks.TasksRequest;
import project.codewars.Repositories.TasksRepository;
import project.codewars.Service.TasksService;

@RestController
@AllArgsConstructor
public class TaskController {

    private final TasksRepository tasksRepository;
    private final TasksService tasksService;

    @PostMapping("/addtask")
    public void addtask(@RequestBody TasksRequest tasksRequest, String token) {
        tasksService.addtask(tasksRequest, token);
    }
}
