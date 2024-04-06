package project.codewars.DTO.Tasks;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TasksRequest {

    private String name;
    private String description;
    private String right_solution;
    private Integer rank;
    private Integer task_points;
    private Integer completion_times;
    private Integer bookmark;
    private String tags;

}
