import java.util.Scanner;

public class FacultyAgent implements Strategy {
    public Items items;
    public ItemFaculty itemFaculty;

    public FacultyAgent(Items items, ItemFaculty itemFaculty) {
        this.items = items;
        this.itemFaculty = itemFaculty;
    }

    @Override
    public void Init() {
        System.out.println("You`re welcome in FacultyAgent Page!");
        System.out.println("What do you want to do?");
        System.out.println("1 - choose faculty\n2 - faculty for customer \n3 - exit.");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int flag = 1;
        while (flag==1) {
            switch (n) {
                case 1:
                    System.out.println("Choose hot tour: ");
                    int tourId = in.nextInt();
                    itemFaculty.FindFacultyById(tourId);
                    itemFaculty.SetHot(tourId);
                    break;
                case 2:
                    System.out.println("Which customer will has sale?");
                    int clientId = in.nextInt();
                    items.FindClientById(clientId);
                    System.out.println("Write sale:");
                    int ssale = in.nextInt();
                    items.SetSale(clientId, ssale);
                    break;
                case 3:
                    System.out.println("Have a nice day!");
                    flag = 0;
                    break;
                    default:
                    System.out.println("Please choose number from 1 to 3.");
            }
        }
    }
}
