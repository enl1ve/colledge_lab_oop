import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     int flag = 0;
        Items items = new Items();
        Client client1 = new Client(1, "Nikita", 0);
        Client client2 = new Client(1, "Chiachivili", 0);

        items.AddClient(client1);
        items.AddClient(client2);

        ItemFaculty itemTour = new ItemFaculty();
        Faculty tour1 = new Faculty(1, "Shopping", "Filosofi", null, client1);
        Faculty tour3 = new Faculty(3, "chill", "hihi haha", null, client2);

        itemTour.AddFaculty(tour1);
        itemTour.AddFaculty(tour3);
        System.out.println("Main Menu");
        System.out.println("1 - Faculty Agent Page\n2 - Customer Page\n3 - exit.");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (flag == 0) {
            switch (n) {
                case 1:
                    Context context = new Context(new FacultyAgent(items, itemTour));
                    context.executeStrategy();
                    break;
                case 2:
                    Context context1 = new Context(new Customer(itemTour));
                    context1.executeStrategy();
                    break;
                case 3:
                    System.out.println("Good night!");
                    flag = 1;
                    break;
                default:
                    System.out.println("Please, only from 1 to 3");
            }
        }
    }

}