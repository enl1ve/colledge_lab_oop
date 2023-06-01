import java.util.ArrayList;
import java.util.List;

public class ItemFaculty {
    public List<Faculty> facultyList;
    public ItemFaculty() {
        facultyList = new ArrayList<>();
    }
    public void AddFaculty(Faculty faculty) {
        facultyList.add(faculty);
    }
    public Faculty FindFacultyById(int id) {
        for (Faculty c : facultyList) {
            if (id == c.getId()) {
                return c;
            }
        }
        return null;
    }
    public void SetHot(int id) {
        Faculty faculty1 = FindFacultyById(id);
        faculty1.setStatus("Hot");
    }
}
