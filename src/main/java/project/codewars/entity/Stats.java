package project.codewars.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String created_date;
    private String published_date;
    private Integer warriors_trained;

    @OneToOne(mappedBy = "stats")
    private Tasks tasks;
}
