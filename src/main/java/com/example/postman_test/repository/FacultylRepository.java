package com.example.postman_test.repository;

import com.example.postman_test.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultylRepository extends JpaRepository<Faculty, Long> {
}
