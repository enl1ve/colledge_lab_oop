package ua.com.lb14;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int flag = 0;
        ItemClient itemClient = new ItemClient();
        ItemIFaculty itemIFaculty = new ItemIFaculty();
        ItemFaculty itemFaculty = new ItemFaculty();
        Scanner in = new Scanner(System.in);
        while (flag == 0) {
            System.out.println("Main Menu");
            System.out.println("1 - Faculty Agent Page\n2 - Customer Menu Page\n3 - exit.");
            int n = in.nextInt();
            switch (n) {
                case 1:
                    Context context = new Context(new
                            FacultyAgentMenu(itemClient, itemFaculty, itemIFaculty));
                    context.executeStrategy();
                    break;
                case 2:
                    Context context1 = new Context(new
                            CustomerMenu(itemClient, itemFaculty));
                    context1.executeStrategy();
                    break;
                case 3:
                    System.out.println("Good night!");
                    flag = 1;
                    break;
                default:
                    System.out.println("Please, only from 1 to 3"); break;
            }
        }
    }
}