package register;

import java.util.Scanner;

import Register.Register;

import java.util.Scanner;

public class RegisterLogin {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		System.out.println("'WELCOME'");
		System.out.println("Enter your option");
		System.out.println("Enter 1 for Register");
		System.out.println("Enter 2 for Login");
		System.out.println("Enter 3 for Admin login");
		int option = sc.nextInt();
		/*
		 * while(option>=3) { System.out.println("Enter a valid password");
		 * option=i.nextInt(); }
		 */

		// enter option register or login
		if (option == 1) {
			Register.registration();
		} 
		if (option == 2) {
			Register.logininputs();

		}
		
		if(option == 3) {
			Register.loginadmin();
		}
		
	}

// Registervalid.menu();

}
