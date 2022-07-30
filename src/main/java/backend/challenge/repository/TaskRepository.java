package backend.challenge.repository;
import backend.challenge.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, String> {

}
