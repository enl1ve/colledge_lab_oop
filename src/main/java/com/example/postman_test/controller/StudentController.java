package com.example.postman_test.controller;

import java.util.Optional;

import com.example.postman_test.entity.Student;
import com.example.postman_test.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent() {
        try {
            List<Student> students = studentRepository.findAll();

            if (students.isEmpty()) {
                return new ResponseEntity<>(students, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(students, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById (@PathVariable("id") Long id) {

        Optional<Student> student = studentRepository.findById(id);

        if (student.isPresent()) {
            return new ResponseEntity<>(
                    student.get(),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Student> saveNewStudent (@RequestBody Student student) {
        try {
            Student student1 = studentRepository.save(student);
            return new ResponseEntity<>(student1,  HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent (@PathVariable("id") Long id,
                                                  @RequestBody Student student) {

        Optional<Student> studentOptional = studentRepository.findById(id);

        try {
            if (studentOptional.isPresent()) {
                Student student1 = studentOptional.get();

                student1.setName("petya");
                student1.setSurname("roshan");
                student1.setEmail("student@gmail.com");

                Student student2 = studentRepository.save(student1);

                return new ResponseEntity<>(student2, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById (@PathVariable("id") Long id) {
        try {
            studentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllStudent() {
        try {
            studentRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
