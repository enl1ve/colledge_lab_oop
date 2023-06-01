package ua.com.lb14;

import java.util.ArrayList;
import java.util.List;
public class ItemClient {
    public List<Client> clientsList;
    int counter = 1;
    public ItemClient() {
        clientsList = new ArrayList<>();
    }
    public void AddClient(Client client) {
        client.setId(counter++);
        clientsList.add(client);
    }
    public Client FindClientById(int id) {
        for (Client c : clientsList) {
            if (id == c.getId()) {
                return c;
            }
        }
        return null;
    }
    public void SetSale(int id, int sale) {
        Client client = FindClientById(id);
        if (client != null) {
            client.setSale(sale);
            System.out.println("The discount is set for a customer with an identifier: " + id);
        } else {
            System.out.println("Client with an identifier: " + id + " not found.");
        }
    }
}
