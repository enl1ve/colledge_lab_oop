package com.example.postman_test.controller;

import java.util.Optional;

import com.example.postman_test.entity.Faculty;
import com.example.postman_test.repository.FacultylRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/optional")
public class FacultyController {
    private final FacultylRepository facultylRepository;

    public FacultyController(FacultylRepository facultylRepository) {
        this.facultylRepository = facultylRepository;
    }

    @GetMapping
    public ResponseEntity<List<Faculty>> getAllOptional() {
        try {
            List<Faculty> faculties = facultylRepository.findAll();

            if (faculties.isEmpty()) {
                return new ResponseEntity<>(faculties, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(faculties, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getOptionalById(@PathVariable("id") Long id) {

        Optional<Faculty> faculty = facultylRepository.findById(id);

        if (faculty.isPresent()) {
            return new ResponseEntity<>(
                    faculty.get(),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Faculty> saveNewFaculty (@RequestBody Faculty faculty) {
        try {
            Faculty faculty1 = facultylRepository.save(faculty);
            return new ResponseEntity<>(faculty1,  HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Faculty> updateFaculty (@PathVariable("id") Long id,
                                                  @RequestBody Faculty faculty) {

        Optional<Faculty> facults = facultylRepository.findById(id);

        try {
            if (facults.isPresent()) {
                Faculty faculty1 = facults.get();

                faculty1.setName("dota");
                faculty1.setDescription("dota2");

                Faculty faculty2 = facultylRepository.save(faculty1);

                return new ResponseEntity<>(faculty1, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFacultyById (@PathVariable("id") Long id) {
        try {
            facultylRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllFaculty() {
        try {
            facultylRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
