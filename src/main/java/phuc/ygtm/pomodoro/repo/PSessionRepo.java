package phuc.ygtm.pomodoro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phuc.ygtm.pomodoro.model.PSession;

@Repository
public interface PSessionRepo extends JpaRepository<PSession, Long> {
}
