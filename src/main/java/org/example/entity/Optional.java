package org.example.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "optionals")
public class Optional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameOptional;
    private String nameTeacher;
    private String surnameTeacher;
    @ManyToOne
    @JoinColumn(name = "students_id")
    private Student student;
}
