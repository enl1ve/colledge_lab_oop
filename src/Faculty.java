public class Faculty {

    private int id;
    private String name;
    private String description;
    private String status;
    private Client client;


    public Faculty(int id, String name, String description, String status, Client client) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.client = client;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + description +
                ", status='" + status + '\'' +
                ", client=" + client +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public String setStatus(String status) {
        return status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
