package ua.com.example.lb13.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ua.com.example.lb13.Entity.Category;
import ua.com.example.lb13.Repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    public static final String KEY = "cacheKey";
    private final CategoryRepository categoryRepository;
    @Autowired
    public CategoryService(CategoryRepository categoryRepository) { this.categoryRepository = categoryRepository;
    }
    // @Cacheable("category")
    @CacheEvict(cacheNames = "cat", key = "#root.target.KEY")
    public void saveNewCategory(Category category) {
        categoryRepository.save(category);
    }
    @Cacheable(value = "cat", key = "#root.target.KEY")
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }
    @Cacheable(cacheNames = "category", key = "#id")
    public Category findCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id); if (category.isPresent()) {
            return category.get();
        } else {
            return category.orElseThrow();
        }
    }
    @CacheEvict(cacheNames = "cat", key = "#root.target.KEY")
    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }
    @CacheEvict(cacheNames = "cat", key = "#root.target.KEY")
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}