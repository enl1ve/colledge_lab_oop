package ua.com.example.lb13.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ua.com.example.lb13.Entity.Faculty;
import ua.com.example.lb13.Repository.FacultyRepository;

import java.util.List;
import java.util.Optional;
@Service
public class FacultyService {
    public static final String KEY = "cacheKey";
    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    // @Cacheable("rate")
    @CacheEvict(cacheNames = "dog", key = "#root.target.KEY")
    public void saveNewFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
    }
    @Cacheable(value = "dog", key = "#root.target.KEY")
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }
    @Cacheable(cacheNames = "faculty", key = "#id")
    public Faculty findFacultyById(Long id) {
        Optional<Faculty> faculty = facultyRepository.findById(id);
        if (faculty.isPresent()) {
            return faculty.get();
        } else {
            return faculty.orElseThrow();
        }
    }
    @CacheEvict(cacheNames = "dog", key = "#root.target.KEY")
    public void updateFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
    }
    @CacheEvict(cacheNames = "dog", key = "#root.target.KEY")
    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }
}