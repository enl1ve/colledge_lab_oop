package ua.com.lb14;

import java.util.HashMap;
import java.util.Map;
public class TourFactory {
    private static final Map<String, IFaculty> tours = new HashMap<>(); public IFaculty getTourByType(String type) {
        IFaculty iFaculty = tours.get(type);
        if (iFaculty == null) {
            switch (type) {
                case "Shopping":
                    System.out.println("Have a great shopping!");
                    iFaculty = new ShoppingFaculty();
                    break;
                case "Excursion":
                    System.out.println("Have a great excursion!"); iFaculty = new ExcursionFaculty();
                    break;
                case "Chill":
                    System.out.println("Have a great holiday tour!"); iFaculty = new ChillFaculty();
                    break;
            }
            tours.put(type, iFaculty);
        }
        return iFaculty;
    }
}
