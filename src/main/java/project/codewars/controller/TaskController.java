package project.codewars.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.codewars.DTO.Tasks.TasksRequest;
import project.codewars.Service.TasksService;

@RestController
@AllArgsConstructor
public class TaskController {

    private final TasksService tasksService;

    @PostMapping("/addtask")
    public void addtask(@RequestBody TasksRequest tasksRequest, @RequestHeader("Authorization") String token) {
        tasksService.addtask(tasksRequest, token);
    }
}
