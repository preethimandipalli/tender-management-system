package businesslogic;

import java.util.ArrayList;
import java.util.Scanner;

import model.User;

public class LoginValidation {

	public static User validation(ArrayList<User> listk, String emailId, String password) {

		User flag = null;
		System.out.println(listk.size());
		for (User l : listk) {
			System.out.println("email    " + l.getEmailId());
			if (l.getEmailId().equals(emailId) && l.getPassword().equals(password)) {
				flag = l;
				break;
			}
		}
		return flag;

	}

}
