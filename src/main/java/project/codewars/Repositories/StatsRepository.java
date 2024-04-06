package project.codewars.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.codewars.entity.Stats;

public interface StatsRepository extends JpaRepository<Stats, Long> {
}
