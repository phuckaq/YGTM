package phuc.ygtm.pomodoro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phuc.ygtm.pomodoro.model.PConfig;

@Repository
public interface PConfigRepo extends JpaRepository<PConfig, Long> {
}
