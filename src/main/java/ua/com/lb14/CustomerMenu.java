package ua.com.lb14;

import java.util.Scanner;
public class CustomerMenu implements Strategy{
    public ItemClient itemClient;
    public ItemFaculty itemFaculty;
    public CustomerMenu(ItemClient itemClient, ItemFaculty itemFaculty) { this.itemClient = itemClient;
        this.itemFaculty = itemFaculty;
    }
    @Override
    public void Init() {
        int flag = 1;
        Scanner in = new Scanner(System.in);
        while(flag == 1) {
            System.out.println("You`re welcome in Customer Menu Page!"); System.out.println("What do you want to do?");
            System.out.println("1 - add new client\n2 - exit."); int n = in.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Write client`s name:"); in.nextLine();
                    String name = in.nextLine();
                    Client client1 = new Client(name);
                    itemClient.AddClient(client1);
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
