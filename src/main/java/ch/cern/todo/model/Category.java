
package ch.cern.todo.model;
import jakarta.persistence.*;



@Entity
@Table(name = "Category") // Define the table name in the database
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private long id;

    @Column(name = "category_name", nullable = false, length = 100)
    private String name;

    @Column(name = "category_description", nullable = false, length = 500)
    private String description = "";

    // Constructors
    public Category() {
        // Default constructor required by JPA
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
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