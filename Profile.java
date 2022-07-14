package com.main;

import com.db.DB;
import com.users.employeeProfile;
import com.users.poProfile;

import java.util.Scanner;

public class Profile {

	public static void main(String[] args) {
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
			case 2:
				poProfile po = new poProfile();
				System.out.println("Enter PO id: ");
				int poID = new Scanner(System.in).nextInt();
				po = db.fetchPO(poID);
				po.display();
				
				
		}
	}

}
