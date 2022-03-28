package Register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginValidationUsingDatabase {
	public static String loginValidatorUsingDatabase(String email, String password) throws Exception {
		// Step 1 : Database Driver ( Optional)
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2: Get the Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://101.53.133.59:3306/revature_training_db",
				"rev_user", "rev_user");
		//System.out.println(connection);
		String query = "SELECT EmailId,user_Password FROM leave_management_system WHERE EmailId='" + email + "'";
		Statement st = (Statement) connection.createStatement();
		ResultSet rs = ((java.sql.Statement) st).executeQuery(query);
		String mail = null;
		String Password = null;
		while (rs.next()) {
			mail = rs.getString("EmailId");
			Password = rs.getString("user_Password");
		}
		if (mail == null) {
			throw new Exception("No Records Found");
		} else if (Password.equals(password)) {
			System.out.println("Success!!!..Logging you in..");
			return mail;
		} else {
			throw new Exception("Invalid Credentials");
		}

	}
}
