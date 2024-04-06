package project.codewars.Service;

import project.codewars.DTO.Tasks.TasksRequest;

public interface TasksService {
    void addtask(TasksRequest tasksRequest, String token);
}
