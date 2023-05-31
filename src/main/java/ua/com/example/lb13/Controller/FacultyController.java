package ua.com.example.lb13.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.example.lb13.Entity.Category;
import ua.com.example.lb13.Entity.Faculty;
import ua.com.example.lb13.Service.FacultyService;

import java.math.BigDecimal;
@Controller
public class FacultyController {
    private final FacultyService facultyService;
    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @GetMapping("/faculty")
    public String getHome(Model model){
        model.addAttribute("faculty", facultyService.getAllFaculty());
        return "facultyindex";
    }
    @GetMapping("/faculty/{id}")
    public String getRateById(@PathVariable("id") Long id,
                              Model model){
        model.addAttribute("faculty",facultyService.findFacultyById(id));
        return "faculty";
    }
    @PostMapping("/savefaculty")
    public String saveNewRate(@RequestParam(name = "name") String name1,
                              @RequestParam(name = "description") String description,
                              @RequestParam(name = "image") String image,
                              @RequestParam(name = "category") Category category
    ){
        Faculty faculty = new Faculty();
        faculty.setName(name1);
        faculty.setDescription(description);
        faculty.setImage(image);
        faculty.setCategories(category);
        facultyService.saveNewFaculty(faculty);
        return "redirect:/rate";
    }
    @PostMapping("/updaterate")
    public String updateRate(@RequestParam(name = "id") Faculty faculty,
                             @RequestParam(name = "name") String name,
                             @RequestParam(name = "description") String description,
                             @RequestParam(name = "image") String image,
                             @RequestParam(name = "category") Category category
    ){
        faculty.setDescription(description);
        faculty.setName(name);
        faculty.setImage(image);
        faculty.setCategories(category);
        facultyService.updateFaculty(faculty);
        return "redirect:/rate";
    }
    @PostMapping("/deleterate")
    public String deleteRateById(@RequestParam(name = "id") Long id){ facultyService.deleteFaculty(id);
        return "redirect:/rate";
    }
}

