public class projectDetails {
    private int id;
    private String name;
    private String description;
    private String creationDate;
    private String currentStatus;
    private int tier;

    public projectDetails(int id, String name, String description, String creationDate, String currentStatus,
            int tier) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.currentStatus = currentStatus;
        this.tier = tier;
    }

    public projectDetails() {

    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public String getcreationDate() {
        return creationDate;
    }

    public void setcreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getcurrentStatus() {
        return currentStatus;
    }

    public void setcurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public String toString() {
        return "projectDetails [ID = " + id + ", name=" + name + ", description=" + description + ", creation date: "
                + creationDate
                + ", Current status: " + currentStatus + ", tier: " + tier + ", toString()=" + super.toString() + "]";
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("name: " + name);
        System.out.println("description: " + description);
        System.out.println("creation date: " + creationDate);
        System.out.println("current status: " + currentStatus);
        System.out.println("priority tier level: " + tier);
    }
}
