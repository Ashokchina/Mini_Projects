package in.ashokit.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import in.ashokit.entity.State;

public interface StateRepo extends JpaRepository<State, Integer> {
    List<State> findStatesByCid(Integer cid);
}
