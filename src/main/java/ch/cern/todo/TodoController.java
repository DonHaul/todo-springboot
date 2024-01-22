package ch.cern.todo;
import ch.cern.todo.model.Category;
import ch.cern.todo.model.Todo;
import ch.cern.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/all")
    public List<Todo> getAllTodos(){
        return (List<Todo>) todoRepository.findAll();
    }



    @GetMapping("/{id}")
    public String getTodoById(@PathVariable long id, Model model) {
        Optional<Todo> todo = todoRepository.findById(id);
        model.addAttribute("todo", todo);
        return "todo";
    }


    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    @PutMapping("/{id}")
    public Todo updatePerson(@PathVariable Long id, @RequestBody Todo updatedPerson) {
        Todo existingPerson = todoRepository.findById(id).orElse(null);
        //if (existingPerson != null) {
       //     existingPerson.setName(updatedPerson.getName());
        return todoRepository.save(existingPerson);
        //}
        //return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable long id) {
        todoRepository.deleteById(id);
    }
}

