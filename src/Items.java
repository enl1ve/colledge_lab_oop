import java.util.ArrayList;
import java.util.List;

public class Items {
    public List<Client> clientsList;
    public  Client client;

    public Items() {
        clientsList = new ArrayList<>();
    }
    public void AddClient(Client client) {
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
        client = FindClientById(id);
        client.setSale(sale);
    }
}
