
package ch.cern.todo.model;
import jakarta.persistence.*;
import java.util.Date;

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
    private String description = "";

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deadline", nullable = true)
    private Date deadline = new Date();


    // Constructors
    public Todo() {
        // Default constructor required by JPA
    }

    public Todo(String name, String description, Category category, Date deadline) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.deadline = deadline;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    // Setter for completeness (not recommended to use)
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getDeadline() {
        return deadline;
    }
}
