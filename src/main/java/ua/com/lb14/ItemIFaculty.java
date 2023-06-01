package ua.com.lb14;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class ItemIFaculty {
    public Faculty faculty;
    public List<IFaculty> itours;

    public ItemIFaculty() {
        itours = new ArrayList<>();
    }

    public void GetDescTour(Faculty faculty) {
        TourFactory tourFactory = new TourFactory();
        if (Objects.equals(faculty.getName(), "Shopping")) {
            itours.add(tourFactory.getTourByType("Shopping"));
        } else if (Objects.equals(faculty.getName(),
                "Excursion")) {
            itours.add(tourFactory.getTourByType("Excursion"));
        } else if (Objects.equals(faculty.getName(), "Chill")) {
            itours.add(tourFactory.getTourByType("Chill"));
        }
        for (IFaculty iTours : itours) {
            iTours.Description();
        }
    }
}
