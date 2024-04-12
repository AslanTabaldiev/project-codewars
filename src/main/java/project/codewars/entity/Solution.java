package project.codewars.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String warrior_solution;

    @ManyToOne()
    private Warrior warrior;
}
