package businesslogic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterationValidation {
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	private Pattern pattern;
	private Matcher matcher1, matcher2;

	public boolean checkUserDetails(String email, String password, String confirmPassword) {
		if (validEmail(email) && validPassword(password, confirmPassword))
			return true;
		else
			return false;
	}

	private boolean validPassword(String password, String confirmPassword) {

		pattern = Pattern.compile(PASSWORD_PATTERN);
		if (password.equals(confirmPassword)) {

			matcher1 = pattern.matcher(password);
			matcher2 = pattern.matcher(confirmPassword);

			if ((matcher2.matches() && matcher1.matches()) == true) {
				return true;
			} else {
				System.out.println(
						"password should contain atleast 6 characters and max 20 characters , atleast one number and one capital letter");
				return false;

			}
		}
		System.out.println("password and confirm password are not same!!!!!");
		return false;

	}

	private boolean validEmail(String email) {

		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if (email.matches(regex) == false) {
			System.out.println("Email id should contain atleast 6 and max 20 characters");
			return false;
		}
		return true;

	}

}
