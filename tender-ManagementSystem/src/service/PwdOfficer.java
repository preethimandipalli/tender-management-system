package service;

import model.Tender;
import businesslogic.RegisterationValidation;
import model.User;
import model.UserRegistration;

public class PwdOfficer {

	int bidprice = Integer.MAX_VALUE;

	public void declarewinner(int p, User u, int bp, Tender t) {
		if (p <= bidprice && p >= bp) {

			t.winner = u;
			bidprice = p;

		}

	}

}
