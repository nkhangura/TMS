package com.main;

import java.util.List;
import java.util.Scanner;

import com.workLog.*;
import com.main.DB;
import com.projects.projectDetails;
import com.users.employeeProfile;
import com.users.poProfile;

public class menus {

		

		public static void mainMenu() {
	        boolean quit = false;
	        Scanner sc = new Scanner(System.in);
	        while (!quit) {
	            System.out.println("------------TMS--------------");
	            System.out.println("Enter 1: profile system");
	            System.out.println("Enter 2: worklog system");
	            System.out.println("Enter 3: enter project information");
	            //System.out.println("Enter 4: reset password");
	            System.out.println("Enter 0: quit");
	            int input = sc.nextInt();
	            if (input == 0) {
	                System.out.println("Exiting.. Bye!!");
	                break;
	            }
	            switch (input) {
	                case 1:
	                    profilesMenu();
	                    mainMenu();
	                    break;
	                case 2:
	                    workLogMenu();
	                    mainMenu();
	                    break;
	                case 3:
	                	projectMenu();
	                	mainMenu();
	                	break;
	                case 4:
	                    System.exit(0);
	                    break;
	            }
	        }
		}
		
		public static void profilesMenu() {
			DB db = new DB();
			
			System.out.println("Select 1 for employee or 2 for product owner.");
			Scanner scanner = new Scanner(System.in);
			int input = scanner.nextInt();
			
			switch(input) {
				case 1:
					employeeProfile ep = new employeeProfile();
					System.out.println("Enter employee id: ");
					int employeeID = new Scanner(System.in).nextInt();
					ep = db.fetchEmployee(employeeID);
					ep.display();
					break;
				case 2:
					poProfile po = new poProfile();
					System.out.println("Enter PO id: ");
					int poID = new Scanner(System.in).nextInt();
					po = db.fetchPO(poID);
					po.display();
					break;
					
					
			}
		}
		
		public static void workLogMenu() {
			DB db = new DB();
			
			// Menu for Employee
			WorkLog worklog = new WorkLog();
			while (true) {
				Scanner sc = new Scanner(System.in);
				System.out.println("-------- WorkLog System Menu -------");
				System.out.println("  1. Create WorkLog");
				System.out.println("  2. Update WorkLog Description");
				System.out.println("  3. Delete WorkLog");
				System.out.println("  4. Show Employee's WorkLogs");
				System.out.println("  5. Show All WorkLogs");
				System.out.println("  0. To Exit");
				System.out.println("Enter your input");
				int input = sc.nextInt();
				if (input == 0) {
					System.out.println("Exiting.. Bye!!");
					break;
				}
				switch(input) {
				case 1:
					// Get input from employee
					System.out.println("Enter the WorkLog Description");
					sc.nextLine();
					String description = sc.nextLine();
					System.out.println("Enter the WorkLog Creation Date");
					//sc.nextLine();
					String creationDate = sc.next();//Line();
					System.out.println("Enter the Employee ID for this WorkLog");
					int employeeId = sc.nextInt();
					// Set values to input
					worklog.setDescription(description);
					worklog.setCreationDate(creationDate);
					worklog.setEmp_id(employeeId);
					// Create new worklog & add it to worklog table
					db.createWorklog(worklog);
					System.out.println("WorkLog successfully created!");
					break;
				case 2:
					// Show all worklog ids 
					System.out.println("Showing All WorkLog IDs available:");
					System.out.println("----------------------------------");
					List<WorkLog> worklogList = db.getAllWorkLogs();
					worklogList.stream().forEach(w->System.out.println("WorkLog ID: " + w.getId()));
					// Get worklog to update from employee
					System.out.println("Enter WorkLog ID to Update");
					int worklogID = sc.nextInt();
					Utilities newUtility = new Utilities();
					// Check if valid worklog
					boolean validWorkLog = newUtility.validateWorkLogID(db.getAllWorkLogs(), worklogID);
					if(!validWorkLog) {
						System.out.println("Invalid WorkLog ID. WorkLog does not exist.");
						break;
					}	
					
					
					// Restrict update operation to employee's own worklogs
			/*
			 * Should connect to employee to check without re-entering employee id
			 * */
					System.out.println("Re-enter Employee ID:");
					int empid = sc.nextInt();
					newUtility = new Utilities();
					// Check if valid worklog
					boolean worklogMatchesEid = newUtility.validateWorkLogIDUnderCurrentEmployee(worklogList, worklogID, empid);
					if(!worklogMatchesEid) {
						System.out.println("WorkLog does not exist for current employee.");
						break;
					}
					
					
					// Retrieve worklog information
					WorkLog wLog = db.getWorkLogToUpdate(worklogID);
					System.out.println("Showing current record for WorkLog ID: "+ worklogID);
					System.out.println("-------------------------------------------");
					System.out.println(wLog);
					// Get new information for the worklog
					System.out.println("Enter the New WorkLog Description");
					sc.nextLine();
					description = sc.nextLine();
					
			/*
			 *  Not sure if we should be able to update creation date and employee id
			 */		
					
			/*		System.out.println("Enter the New WorkLog Creation Date");
					sc.nextLine();
					creationDate = sc.nextLine();
					System.out.println("Enter the New Employee ID for this WorkLog");
					employeeId = sc.nextInt();
			 */				
					wLog.setDescription(description);
					
			/*		wLog.setCreationDate(creationDate);
					wLog.setEmp_id(employeeId);
					
			 */		// Update worklog info in WorkLog table
					db.updateWorkLogInfo(wLog);	
					System.out.println("WorkLog successfully updated!");
					break;
				case 3:
					System.out.println("Enter WorkLog ID to Delete");
					worklogID = sc.nextInt();
					// Check if valid worklog
					newUtility = new Utilities();
					validWorkLog = newUtility.validateWorkLogID(db.getAllWorkLogs(),worklogID);
					if(!validWorkLog) {
						System.out.println("Invalid WorkLog ID. WorkLog does not exist.");
						break;
					}
					
					
					// Restrict update operation to employee's own worklogs
			/*
			 * Should connect to employee to check without re-entering employee id
			 * */
					System.out.println("Re-enter Employee ID:");
					empid = sc.nextInt();
					newUtility = new Utilities();
					// Check if valid worklog
					worklogMatchesEid = newUtility.validateWorkLogIDUnderCurrentEmployee(db.getAllWorkLogs(), worklogID, empid);
					if(!worklogMatchesEid) {
						System.out.println("WorkLog does not exist for current employee.");
						break;
					}
					
					
					// Delete given worklog from WorkLog table
					db.deleteWorklog(worklogID);
					System.out.println("WorkLog successfully deleted!");
					//break;
				case 4:
					
					System.out.println("Showing Employee's worklogs:");
					System.out.println("----------------------------");
					// Restrict update operation to employee's own worklogs
			/*
			 * Should connect to employee to check without re-entering employee id
			 * */
					System.out.println("Re-enter Employee ID:");
					empid = sc.nextInt();
					worklogList = db.getEmployeeWorkLogs(empid);
					worklogList.stream().forEach(w->System.out.println(w));
					//break;
				case 5:
					// Display list with all the worklogs
					System.out.println("Showing all worklogs:");
					System.out.println("---------------------");
					worklogList = db.getAllWorkLogs();
					for(WorkLog w : worklogList) {
						System.out.println(w);
					}
					break;
				default:
					System.out.println("Invalid option! Please choose from the WorkLog System Menu");
					break;
				}

			}
		}
		
		public static void projectMenu() {
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

