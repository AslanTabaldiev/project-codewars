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
    private Integer total_code_submission;
    private Integer total_times_completed;


    @OneToOne(mappedBy = "stats")
    private Tasks tasks;
}
