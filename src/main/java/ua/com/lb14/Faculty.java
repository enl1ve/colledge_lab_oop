package ua.com.lb14;

public class Faculty {
    private int id;
    private String name;
    private String description;
    private String status;
    public Faculty(String name, String description) {
        this.name = name;
        this.description = description;
    }
    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description=" + description +
                ", status='" + status +
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
}