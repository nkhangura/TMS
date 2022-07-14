import java.util.Scanner;

public class project {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // projectDetails p1 = new projectDetails();
        String name, description, creationDate, currentStatus;
        int tier, id;
        System.out.println();
        System.out.println("Enter the project id: ");
        id = sc.nextInt();
        sc.nextLine();
        // p1.setID(id);

        System.out.println("Enter the project name: ");
        name = sc.nextLine();
        // p1.setname(name);

        System.out.println("Enter the project description: ");
        description = sc.nextLine();
        // p1.setdescription(description);

        System.out.println("Enter the todays date: (Ex: 2021-12-23)");
        creationDate = sc.nextLine();

        System.out.println("Enter the project current status: ");
        currentStatus = sc.nextLine();

        System.out.println("Enter the priority level: ");
        tier = sc.nextInt();

        System.out.println("");
        projectDetails p2 = new projectDetails(id, name, description, creationDate, currentStatus, tier);

        p2.display();
        sc.close();
    }
}