package controller;

import java.util.*;
import businesslogic.LoginValidation;
import service.PwdOfficer;
import service.StateGovtOfficer;
import model.Tender;
import service.Builder;
import model.User;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<User> builder_list = new ArrayList<User>();
		ArrayList<User> stateGovtOfficers_list = new ArrayList<User>();
		ArrayList<User> PwdOfficers_list = new ArrayList<User>();
		ArrayList<Tender> tender_list = new ArrayList<Tender>();
		Map<User, ArrayList<Tender>> builderMap = new HashMap<User, ArrayList<Tender>>();
		Map<Tender, ArrayList<User>> tenderMap = new HashMap<Tender, ArrayList<User>>();
		PwdOfficers_list.add(new User("priya", "p", "priya", 1, "priya11@gmail.com", "preethi99@", "preethi99@"));
		PwdOfficer pwdOffice = new PwdOfficer();

		boolean exit = false;
		String emailId, password;
		while (exit == false) {
			System.out.println("Enter 1 if you want login:");
			System.out.println("enter 2 if you want to sign up:");
			System.out.println("Enter any other number if you want  to exit:");
			int options = sc.nextInt();
			if (options == 1) {
				System.out.println("Enter 1 if you want to login as builder");
				System.out.println("Enter 2 if you want to login as pwd ofiicer");
				System.out.println("Enter 3 if you want to login as state government officer ");
				int login_option;
				login_option = sc.nextInt();
				System.out.println("enter your email");
				emailId = sc.next();
				System.out.println("enter your password");
				password = sc.next();

				switch (login_option) {
				case (1):
					User u = LoginValidation.validation(builder_list, emailId, password);
					if (u != null) {
						System.out.println("Enter 1 if you want to view all the tenders available");
						int view = sc.nextInt();
						if (view == 1) {
							StateGovtOfficer stateGovtOfficer = new StateGovtOfficer();
							stateGovtOfficer.viewTender(tender_list);
							System.out.println("Enter 2 to apply for a tender");
							int apply = sc.nextInt();

							if (apply == 2) {
								System.out.println("Enter the name of tender for which you want to apply ");
								String nameOfTender = sc.next();
								System.out.println("Enter the bidprice of tender ");
								int bidprice = sc.nextInt();
								int check_title = 0;
								for (Tender t : tender_list) {
									if ((t.getTitle()).equals(nameOfTender)) {
										if (builderMap.get(u) == null) {
											builderMap.put(u, new ArrayList<Tender>());
										}
										builderMap.get(u).add(t);
										if (tenderMap.get(t) == null) {
											tenderMap.put(t, new ArrayList<User>());
										}
										tenderMap.get(t).add(u);
										check_title = 1;
										pwdOffice.declarewinner(bidprice, u, t.getBaseprice(), t);
										break;

									}

								}
								if (check_title == 0) {
									System.out.println(" tender name is not valid");
								}
							}

						}
					} else {
						System.out.println("login failed!!!!");
					}

					break;
				case (2):

					System.out.println(LoginValidation.validation(PwdOfficers_list, emailId, password));
					break;
				case (3):

					System.out.println(LoginValidation.validation(stateGovtOfficers_list, emailId, password));
					System.out.println(
							"If you want to create a new tender enter 1,enter 2 if you want to view all the tenders you have created,enter 3 if you want to update texisting tender,enter 4 if you want to delete existing tender");
					int newtender = sc.nextInt();
					OperationsOnTender tenderOperations = new OperationsOnTender();
					tenderOperations.OperationsOnTender(newtender, tender_list);
					for (Tender t : tender_list) {
						System.out.println(t.getTitle() + "  " + t.getDescription());
					}

					break;

				}
			}

			else if (options == 2) {
				int option;
				System.out.println("Enter 1 if you want to register as builder");
				System.out.println("enter 3 if you want to reigster as state government officer,enter 4 to exit ");
				option = sc.nextInt();

				Registeration registeration = new Registeration(builder_list, tender_list, stateGovtOfficers_list,
						option);
			}

			else {

				exit = true;
			}
		}

		System.out.println("Winners of each tender are as follows");

		for (Map.Entry<Tender, ArrayList<User>> entry : tenderMap.entrySet()) {

			Tender t = entry.getKey();
			if (t.winner != null) {
				System.out.println(t.getTitle() + " " + t.winner.getEmailId());
			} else {
				System.out.println(t.getTitle() + " " + " none ");
			}
		}

	}
}