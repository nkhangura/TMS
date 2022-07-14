import java.util.Scanner;

public class project {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        projectDetails p1 = new projectDetails();
        String project, projectD, projectAssigned;
        int tier;
        System.out.println("\nEnter the project name: ");
        sc.nextLine();
        project = sc.nextLine();
        p1.setProject(project);
        System.out.println("Enter the project description: ");
        sc.nextLine();
        projectD = sc.nextLine();
        p1.setProjectD(projectD);
        System.out.println("Enter the employee username to assign to: ");
        sc.nextLine();
        projectAssigned = sc.nextLine();
        p1.setAssignedTo(projectAssigned);
        System.out.println("Enter the priority level: ");
        tier = sc.nextInt();
        p1.setTier(tier);
        p1.display();
        sc.close();
    }
}
