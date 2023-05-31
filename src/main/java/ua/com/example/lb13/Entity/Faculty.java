package ua.com.example.lb13.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "faculty")
public class Faculty implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String image;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categories;

    public Faculty(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }
}

