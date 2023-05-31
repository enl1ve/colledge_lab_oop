package ua.com.example.lb13.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.example.lb13.Entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
