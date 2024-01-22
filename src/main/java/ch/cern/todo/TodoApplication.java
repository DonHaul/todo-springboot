package ch.cern.todo;

import ch.cern.todo.model.Todo;
import ch.cern.todo.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

}

@Component
class TodoCommandLineRinner implements CommandLineRunner
{

	@Override
	public void run(String... args) throws Exception {

	}
}