package ua.com.lb14;

import java.util.ArrayList;
import java.util.List;

public class ItemFaculty {
    public List<Faculty> facultyList;
    int counter = 1;
    public ItemFaculty() {
        facultyList = new ArrayList<>();
    }
    public void AddTour(Faculty faculty) {
        faculty.setId(counter++);
        facultyList.add(faculty);
    }
    public Faculty FindTourById(int id) {
        for (Faculty c : facultyList) {
            if (id == c.getId()) {
                return c;
            }
        }
        return null;
    }
    public void SetHot(int id) {
        Faculty faculty1 = FindTourById(id);
        if (faculty1.getStatus() != null) {
            faculty1.setStatus("Hot");
            System.out.println("The status *hot* was recorded."); } else {
            System.out.println("The status *hot* was not recorded."); }
    }
}
