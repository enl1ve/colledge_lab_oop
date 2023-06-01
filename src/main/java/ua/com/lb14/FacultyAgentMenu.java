package ua.com.lb14;

import java.util.Scanner;
public class FacultyAgentMenu implements Strategy {
    public ItemClient itemClient;
    public ItemFaculty itemFaculty;
    public ItemIFaculty itemIFaculty;
    public FacultyAgentMenu(ItemClient itemClient, ItemFaculty itemFaculty, ItemIFaculty itemIFaculty) {
        this.itemClient = itemClient;
        this.itemFaculty = itemFaculty;
        this.itemIFaculty = itemIFaculty;
    }
    @Override
    public void Init() {
        int flag = 1;
        Scanner in = new Scanner(System.in);
        while (flag==1) {
            System.out.println("You`re welcome in FacultyAgentMenu Page!"); System.out.println("What do you want to do?");
            System.out.println("1 - write new faculty\n2 - choose faculty\n3 - sale for customer \n4 - exit.");
            int n = in.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Write faculty name:"); in.nextLine();
                    String name = in.nextLine();
                    System.out.println("Write description of this faculty:"); String description = String.valueOf(in.nextInt());
                    Faculty tour1 = new Faculty(name, description);
                    itemIFaculty.GetDescTour(tour1);
                    itemFaculty.AddTour(tour1);
                    break;
                case 2:
                    System.out.println("Choose faculty: "); int facultyId = in.nextInt();
                    itemFaculty.FindTourById(facultyId);
                    itemFaculty.SetHot(facultyId);
                    break;
                case 3:
                    System.out.println("Which customer will has sale?");
                    int clientId = in.nextInt();
                    itemClient.FindClientById(clientId);
                    System.out.println("Write sale:");
                    int ssale = in.nextInt();
                    itemClient.SetSale(clientId, ssale);
                    break;
                case 4:
                    System.out.println("Have a nice day!"); flag = 0;
                    break;
                default:
                    System.out.println("Please choose number from 1 to 4.");
            }
        }
    }
}