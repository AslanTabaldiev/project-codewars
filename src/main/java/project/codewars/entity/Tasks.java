package project.codewars.entity;

import io.swagger.models.Tag;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String description;
    private String right_solution;
    private Integer rank;
    private Integer task_points;
    private Integer completion_times;
    private Integer bookmark;

    @OneToOne(cascade = CascadeType.ALL)
    private Stats stats;

    @ManyToMany
    @JoinTable(name = "task_tags",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tags> tags = new HashSet<>();
}
