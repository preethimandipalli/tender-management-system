package service;

import java.util.ArrayList;
import java.util.Scanner;

import businesslogic.RegisterationValidation;
import model.Tender;
import model.User;
import model.UserRegistration;

public class StateGovtOfficer {

	Scanner scanner = new Scanner(System.in);

	public User stateGovtOfficerRegistration() {
		UserRegistration userRegistration = new UserRegistration();
		return userRegistration.registerationDetails();

	}

	public Tender createNewTender() {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter tender name");
		String title = sc.next();
		System.out.println("enter tender description");
		sc.nextLine();
		String description = sc.nextLine();
		System.out.println("enter tender base price");
		int price = sc.nextInt();

		return new Tender(title, description, price);

	}

	public void viewTender(ArrayList<Tender> tender_list) {

		System.out.println("All the tenders");

		for (Tender t : tender_list) {
			System.out.println(t.getTitle() + "--> " + t.getDescription());
		}

	}

	public void updateTender(ArrayList<Tender> tender_list, String update_title, String updated_description) {

		for (Tender t : tender_list) {
			if (t.getTitle().equals(update_title)) {
				t.setDescription(updated_description);
				System.out.println("state govt " + t.getTitle() + " " + t.getDescription());
			}
		}

	}

	public void deleteTender(ArrayList<Tender> tender_list, String delete_title) {
		Tender delList = null;
		for (Tender t : tender_list) {
			if (t.getTitle().equals(delete_title)) {
				delList = t;
				break;
			}
		}
		tender_list.remove(delList);
		viewTender(tender_list);

	}
}
