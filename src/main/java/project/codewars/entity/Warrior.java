package project.codewars.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Warrior {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String username;
    private Integer warrior_rank;
    private String registration_date;
    private String last_seen_date;
    private Integer warrior_points;
    private Integer completed_kata;

    @OneToOne(mappedBy = "warrior")
    private User user;

    @OneToMany(mappedBy = "warrior", cascade = CascadeType.ALL)
    private List<Solution> solutions;
}
