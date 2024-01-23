package ch.cern.todo;
import ch.cern.todo.model.Category;
import ch.cern.todo.model.Todo;
import ch.cern.todo.repository.CategoryRepository;
import ch.cern.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/todos")
public class TodoController {

    private static final Logger logger = LoggerFactory.getLogger(TodoController.class);


    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = (List<Todo>) todoRepository.findAll();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public Optional<Todo> getTodoById(@PathVariable long id) {
        return todoRepository.findById(id);
    }


    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {

logger.warn("I AM HERE");


        long category_id = todo.getCategory().getId();
        Optional<Category> category =  categoryRepository.findById(category_id);
        if (category.isEmpty())
        {
            logger.warn("Creating Categ");
            String category_name = todo.getCategory().getName();
            logger.warn("the categ name is {}",category_name);
            category = categoryRepository.findByName(category_name);

            if (category.isEmpty())
            todo.setCategory(categoryRepository.save(new Category(category_name)));
            else
            {todo.setCategory(category.get());}

        }

        return todoRepository.save(todo);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo updatedTodo) {
        logger.warn("UPDATING TO DO {}", id);
        Todo existingTodo = todoRepository.findById(id).orElse(null);
        if (existingTodo != null) {
            existingTodo.setName(updatedTodo.getName());
            existingTodo.setDescription(updatedTodo.getDescription());
            logger.warn("READY TO SAVE");
            long category_id = existingTodo.getCategory().getId();
            Optional<Category> category =  categoryRepository.findById(category_id);
            if (category.isEmpty())
            {
                logger.warn("Creating Categ");
                String category_name = existingTodo.getCategory().getName();
                existingTodo.setCategory(categoryRepository.save(new Category(category_name)));
            }
            logger.warn("READY TO SAVE");
            logger.warn(existingTodo.getDescription());
            return todoRepository.save(existingTodo);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable long id) {
        todoRepository.deleteById(id);
    }
}

