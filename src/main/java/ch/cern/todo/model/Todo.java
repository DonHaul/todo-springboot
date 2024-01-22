
package ch.cern.todo.model;
import jakarta.persistence.*;


@Entity
@Table(name = "Todo") // Define the table name in the database
public class Todo {

    // Define the foreign key relationship to Category
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private long id;

    @Column(name = "task_name", nullable = false, length = 100)
    private String name;

    @Column(name = "task_description", nullable = false, length = 500)
    private String description;

    // Constructors
    public Todo() {
        // Default constructor required by JPA
    }

    public Todo(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}