package service;

import java.util.*;

import businesslogic.RegisterationValidation;
import model.User;
import model.UserRegistration;

public class Builder {
	Scanner scanner = new Scanner(System.in);

	public User builderRegistration() {
		UserRegistration userRegistration = new UserRegistration();
		return userRegistration.registerationDetails();

	}

}
