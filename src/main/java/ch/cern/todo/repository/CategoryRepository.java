package ch.cern.todo.repository;

import ch.cern.todo.model.Category;
import ch.cern.todo.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
}
