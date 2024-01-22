package ch.cern.todo;

import ch.cern.todo.model.Task;
import ch.cern.todo.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

		@Bean
	CommandLineRunner commandLineRunner(TodoRepository repository){
		return args -> {
			// add some data
			repository.save(new Task(null,  "Test", "Description", "time is now"));
		};
	}
}
