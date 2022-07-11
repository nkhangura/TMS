import java.util.List;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        boolean quit = false;
        Scanner sc = new Scanner(System.in);
        while (!quit) {
            System.out.println("------------TMS--------------");
            System.out.println("Enter 1: log in as user");
            System.out.println("Enter 2: log in as manager");
            System.out.println("Enter 3: create new user");
            System.out.println("Enter 4: reset password");
            System.out.println("Enter 0: quit");
            int input = sc.nextInt();
            if (input == 0) {
                System.out.println("Exiting.. Bye!!");
                break;
            }
            switch (input) {
                case 1:
                    System.out.print("\nEnter employee username: ");
                    String userNameE = sc.next();
                    System.out.print("Enter employee password: ");
                    String employeePass = sc.next();
                    // Check validity of user name and password to login

                    // if logged in
                    int x = 0;
                    System.out.println("\nWelcome " + userNameE);
                    System.out.println("Enter 1: to select from assigned tickets");
                    System.out.println("Enter 2: to view all completed tickets");
                    // for future updates can view completed tickets for latest sprint, qtr
                    x = sc.nextInt();
                    /*
                     * if(x = 1){
                     * Select ticket
                     * Mark complete
                     * Add comment
                     */

                    break;
                case 2:
                    System.out.print("\nEnter manager username: ");
                    String userNameM = sc.next();
                    System.out.println("Enter manager password: ");
                    sc.nextLine();
                    String MPass = sc.nextLine();

                    // Check validity of user name and password to login
                    int y = 0;
                    System.out.println("\nWelcome " + userNameM);
                    System.out.println("\nEnter 1: to create new ticket");
                    System.out.println("Enter 2: to view all open tickets for employee");
                    System.out.println("Enter 3: to view all closed tickets for employee");
                    y = sc.nextInt();

                    /*
                     * Need to fix this part
                     */
                    if (y == 1) {
                        System.out.println("\nEnter the story name: ");
                        sc.nextLine();
                        String story = sc.nextLine();
                        System.out.println("Enter the story description: ");
                        sc.nextLine();
                        String storyD = sc.nextLine();
                        System.out.println(storyD);
                        System.out.println("Enter the employee username to assign to: ");
                        sc.nextLine();
                        String storyAssigned = sc.nextLine();
                        System.out.println("Enter the priority level: ");
                        int tier = sc.nextInt();
                        // once connected to db, sql to complete all the tasks
                    }
                    if (y == 2) {
                        System.out.print("\nEnter the employee username to view all open stories: ");
                        sc.nextLine();
                        String employeeOpen = sc.nextLine();
                    }
                    if (y == 3) {
                        System.out.print("\nEnter the employee username to view all closed stories: ");
                        sc.nextLine();
                        String employeeClosed = sc.nextLine();
                        // for update allow view in sprint and qtr
                    }

                    break;
                case 3:
                    System.out.print("\nEnter the new username: ");
                    sc.nextLine();
                    String newUsername = sc.nextLine();
                    System.out.println("Enter the new password: ");
                    String newPassword = sc.nextLine();
                    System.out.println("Confirm the new password: ");
                    String newPassword2 = sc.nextLine();
                    while (!(newPassword.equals(newPassword2))) {
                        System.out.println("\nThe passwords did not match. Please try again.");
                        System.out.println("Enter the new password: ");
                        newPassword = sc.nextLine();
                        System.out.println("Confirm the new password: ");
                        newPassword2 = sc.nextLine();
                    }
                    System.out.print("If new user is manager enter 1, else enter 0: ");
                    // Temporaily used to see what table to enter new user into. Credentials higher
                    // than manager should be able to add manager.
                    int tier = sc.nextInt();
                    if (tier == 1) {
                        // sql to add to manager table
                    } else {
                        // sql to add as a user
                    }

                    break;

                case 4:
                    System.out.print("\nEnter the new username: ");
                    sc.nextLine();
                    String UsernameR = sc.nextLine();
                    // use sql to chnage password for this user
                    System.out.println("Enter the new password: ");
                    String PasswordR = sc.nextLine();
                    System.out.println("Confirm the new password: ");
                    String PasswordR2 = sc.nextLine();
                    while (!(PasswordR.equals(PasswordR2))) {
                        System.out.println("\nThe passwords did not match. Please try again.");
                        System.out.println("Enter the new password: ");
                        newPassword = sc.nextLine();
                        System.out.println("Confirm the new password: ");
                        newPassword2 = sc.nextLine();
                    }
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Unknon input. Please enter the correct input.");
                    break;
            }
        }

    }
}