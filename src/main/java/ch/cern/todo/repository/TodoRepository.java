package ch.cern.todo.repository;

import ch.cern.todo.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Task,Integer> {
}
