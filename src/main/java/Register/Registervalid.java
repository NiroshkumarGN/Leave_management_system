package Register;

import java.util.*;

public class Registervalid {
	public static void menu() throws Exception {
	}

	public static void validatingRegistration(Userregister car) throws Exception {
		int isNameValid = nameValidation(car.Name);
		int isEmployeeIDValid = EmployeeIDValidation(car.EmployeeID);
		int isGenderValid = GenderValidation(car.Gender);
		int isMobileNumberValid = MobileNumberValidation(car.MobileNumber);
		int isBranchNameValid = BranchValidation(car.BranchName);
		int isEmailID = EmailIDValidation(car.EmailID);
		int isPasswordValid = PasswordValidation(car.Password);

		if (isNameValid + isEmployeeIDValid + isGenderValid + isMobileNumberValid + isBranchNameValid + isEmailID
				+ isPasswordValid == 7) {
			System.out.println("YOU REGISTERED SUCCESSFULLY");

			Registerinsertion.insertUser(car);

		} else {
			throw new Exception("Please Re-Enter Your Details");
		}
	}

	public static int nameValidation(String Name) throws Exception {
		if (Name != null) {
			return 1;
		} else {
			throw new Exception("Enter a Valid Name");
		}
	}

	public static int EmployeeIDValidation(String EmployeeID) throws Exception {
		if (EmployeeID.contains("IOB")) {
			return 1;
		} else {
			throw new Exception("Enter a Valid EmployeeID");
		}
	}

	public static int GenderValidation(String Gender) throws Exception {
		if (Gender.contains("Male") || Gender.contains("Female")) {
			return 1;
		} else {

			throw new Exception("Enter a Valid Gender");
		}
	}

	public static int MobileNumberValidation(String MobileNumber) throws Exception {
		char[] mobile = MobileNumber.toCharArray();
		if (mobile.length == 10) {
			for (char i : mobile) {

				if (Character.isAlphabetic(i))

				{
					throw new Exception("Enter only Numeric values");
				}
			}
			return 1;
		} else {
			throw new Exception("Enter 10 digits");
		}

	}

	public static int BranchValidation(String BranchName) throws Exception {
		if (BranchName.contains("Kancheepuram") || BranchName.contains("Chennai") || BranchName.contains("Chengalpattu")
				|| BranchName.contains("Cheyyur") || BranchName.contains("Coimbatore") || BranchName.contains("Erode")
				|| BranchName.contains("Tambaram") || BranchName.contains("Cuddalore")) {
			return 1;
		} else {
			throw new Exception("Enter a valid Branch name");
		}

	}

	public static int EmailIDValidation(String EmailID) throws Exception {
		if (EmailID.contains("@gmail.com")) {
			return 1;
		} else {
			throw new Exception("Enter Valid Email ID");
		}
	}

	public static int PasswordValidation(String Password) throws Exception {
		if (Password.length() > 7) {
			return 1;
		} else {
			throw new Exception("Enter a Valid Password");
		}
	}

}
