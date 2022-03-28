package Register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Registerinsertion {

	public static void runquery(String query) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://101.53.133.59:3306/revature_training_db",
				"rev_user", "rev_user");

		java.sql.Statement statement = connection.createStatement();
		int rows = statement.executeUpdate(query);
		connection.close();
	}

	public static void insertUser(Userregister obj) throws Exception {
		String query1 = "insert into leave_management_system(Name,EmployeeID,Gender,MobileNumber,BranchName,EmailID,user_password)values('"
				+ obj.Name + "','" + obj.EmployeeID + "','" + obj.Gender + "','" + obj.MobileNumber + "','"
				+ obj.BranchName + "','" + obj.EmailID + "','" + obj.Password + "')";
		System.out.println(query1);

		runquery(query1);
	}

	public static int Update(String query) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://101.53.133.59:3306/revature_training_db",
				"rev_user", "rev_user");
		Statement run = connection.createStatement();
		int rows = run.executeUpdate(query);
		return rows;

	}

}
