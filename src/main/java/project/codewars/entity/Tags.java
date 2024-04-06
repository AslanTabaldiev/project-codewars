package project.codewars.entity;

import jakarta.persistence.*;
import lombok.Data;
import project.codewars.Service.TasksService;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Tasks> tasks = new HashSet<>();
}
