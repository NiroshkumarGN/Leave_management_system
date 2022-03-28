package Register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import java.sql.Statement;

public class Register {
	private static final String String = null;
	//private static final string Approved = null;
	static Scanner sc = new Scanner(System.in);
//	public static String refname=null;
//	public static int refid=0;
	static String name = null;
	static int user = 0;
	public static void registration() {
		System.out.println("Enter your Name");
		String Name = sc.next();
		System.out.println("Enter user EmployeeID");
		String EmployeeID = sc.next();
		System.out.println("Enter Gender .....Male or Female");
		String Gender = sc.next();
		System.out.println("Enter your MobileNumber");
		String MobileNumber = sc.next();
		System.out.println(
				"Enter your BranchName Kancheepuram or Chennai or Chengalpattu or Cheyyur or Coimbatore or Erode or Tambaram or Cuddalore");
		String BranchName = sc.next();
		System.out.println("Enter your E-mail ID");
		String EmailId = sc.next();
		System.out.println("Enter your Password");
		String Password = sc.next();

		Userregister car = new Userregister(Name, EmployeeID, Gender, MobileNumber, BranchName, EmailId, Password);

		try {
			Registervalid.validatingRegistration(car);
		} catch (Exception e) {
			System.out.println("error..!!");
			e.printStackTrace();
		}
	}

	public static void loginadmin() throws Exception {
		System.out.println("Enter your EmailId");
		String email = sc.next();
		System.out.println("Enter your Password");
		String password = sc.next();

		try {
			String y = LoginValidationUsingDatabase.loginValidatorUsingDatabase(email, password);
			System.out.println("Admin login successfull");
			showuserslist();
			//approve_leave(String name,int user);

		} catch (Exception e) {
			System.out.println("error..!!" + e.getMessage());
		}
	}
	
//	public static int approve_leave(String empname,int idemp) {
//		
//		return idemp;
//		
//	}
	
	private static void showuserslist() throws Exception {
		String name = null;
		String user = null;
		ResultSet obj = userlist();
		while (obj.next()) {
			name = obj.getString("Name");
			user = obj.getString("EmployeeID");
			System.out.printf(name);
			System.out.printf("\t" + user);
			System.out.println("");
			System.out.println("Enter 1 to approve leave");
			int u=sc.nextInt();
			if(u==1) {
			approve_leave(user);
			System.out.println("Leave approved");
			}
		}

	}

	private static void approve_leave(String user2) throws Exception {
		String app="Approved";
		String query = "update leave_management_system set leave_status='"+app+"' where EmployeeID='"+user2+"'";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://101.53.133.59:3306/revature_training_db",
				"rev_user", "rev_user");
//		Statement run = connection.createStatement();
//		ResultSet set=run.executeQuery(query);
		Statement run = connection.createStatement();
		int rows = run.executeUpdate(query);
		System.out.println(rows);

	
}

	private static ResultSet userlist() throws Exception {
		String query = "select * from leave_management_system where leave_status='Applied'";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://101.53.133.59:3306/revature_training_db",
				"rev_user", "rev_user");
		Statement run = connection.createStatement();
		ResultSet set=run.executeQuery(query);
		//System.out.println("Activated Succesfully");
		return set;
	}

	public static void logininputs() throws Exception {
		System.out.println("Enter your EmailId");
		String email = sc.next();
		System.out.println("Enter your Password");
		String password = sc.next();

		try {
			String y = LoginValidationUsingDatabase.loginValidatorUsingDatabase(email, password);
			UserMenu(password);
		} catch (Exception e) {
			System.out.println("error..!!" + e.getMessage());
		}
	}

	private static void UserMenu(String password) throws Exception {
		System.out.println("Enter 1 to apply leave");
		int o = sc.nextInt();
		if (o == 1) {

			status(password);

		}

	}

	private static void status(String password) throws Exception {
		String status = "Applied";
		String query = "update leave_management_system set leave_status='" + status + "' where user_password='"+password+"' ";
		Registerinsertion.Update(query);
		System.out.println("Your leave status = " + status);

	}

}

