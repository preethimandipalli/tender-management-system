package controller;

import java.util.ArrayList;
import java.util.Scanner;

import controller.OperationsOnTender;
import model.Tender;
import model.User;
import service.Builder;
import service.StateGovtOfficer;

public class Registeration {

	Scanner sc = new Scanner(System.in);

	public Registeration(ArrayList<User> builder_list, ArrayList<Tender> tender_list,
			ArrayList<User> stateGovtOfficers_list, int option) {

		int validation_check = 0;
		switch (option) {
		case (1):
			validation_check = 0;
			while (validation_check == 0) {
				Builder builder = new Builder();
				User obj = builder.builderRegistration();
				if (obj != null) {
					builder_list.add(obj);
					validation_check = 1;

				} else {
					System.out.println("please re enter your details");
				}
			}
			break;
		case (3):
			validation_check = 0;
			while (validation_check == 0) {
				StateGovtOfficer stateGovtOfficer = new StateGovtOfficer();
				User obj2 = stateGovtOfficer.stateGovtOfficerRegistration();
				if (obj2 != null) {
					stateGovtOfficers_list.add(obj2);
					validation_check = 1;
					while (true) {
						System.out.println(
								"If you want to create a new tender enter 1,enter 2 if you want to view all the tenders you have created,enter 3 if you want to update texisting tender,enter 4 if you want to delete existing tender");
						int newtender = sc.nextInt();
						if (1 <= newtender && newtender < 5) {
							OperationsOnTender tenderOperations = new OperationsOnTender();
							tenderOperations.OperationsOnTender(newtender, tender_list);

						} else {
							break;
						}

					}
				} else {

					System.out.println("please re enter your details");

				}
			}

		}

	}

}
