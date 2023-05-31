package ua.com.example.lb13.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "category")

public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String image;
    @OneToMany(mappedBy = "categories")
    private List<Faculty> facultyList;
    public Category(String name, String description, String image) { this.name = name;
        this.description = description;
        this.image = image;
    }
}
