package spring_boot.task1.repository;

import org.springframework.stereotype.Repository;
import spring_boot.task1.model.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
