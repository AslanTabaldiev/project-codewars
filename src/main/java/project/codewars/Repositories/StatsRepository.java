package project.codewars.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.codewars.entity.Stats;

@Repository
public interface StatsRepository extends JpaRepository<Stats, Long> {
}
