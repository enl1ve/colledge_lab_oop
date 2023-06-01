import java.util.Scanner;

public class Customer implements Strategy{
    public Items items;
    public ItemFaculty itemTour;

    public Customer(ItemFaculty itemTour) {
        this.itemTour = itemTour;
    }

    @Override
    public void Init() {
        int flag = 1;
        System.out.println("You`re welcome in Customer Page!");
        System.out.println("What do you want to do?");
        System.out.println("1 - choose faculty\n2 - exit.");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(flag == 1) {
            switch (n) {
                case 1:
                    System.out.println("Write id of faculty:");
                    int idtour = in.nextInt();
                    itemTour.FindFacultyById(idtour);
                    break;
                case 2:
                    System.out.println("See you soon!");
                    flag = 0;
                    break;
                default:
                    System.out.println("Please choose number from 1 to 2.");
            }
        }
    }

}
