package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.Tender;
import service.StateGovtOfficer;

public class OperationsOnTender {

	Scanner sc = new Scanner(System.in);

	public void OperationsOnTender(int newtender, ArrayList<Tender> tender_list) {
		if (newtender == 1) {

			StateGovtOfficer stateGovtOfficer = new StateGovtOfficer();
			tender_list.add(stateGovtOfficer.createNewTender());

		} else if (newtender == 2) {
			StateGovtOfficer stateGovtOfficer = new StateGovtOfficer();
			stateGovtOfficer.viewTender(tender_list);

		}

		else if (newtender == 3) {
			StateGovtOfficer stateGovtOfficer = new StateGovtOfficer();
			System.out.println("enter title of tender which you want to update");
			String update_title = sc.next();
			System.out.println("enter updated tender description");
			String updated_description = sc.next();
			stateGovtOfficer.updateTender(tender_list, update_title, updated_description);
		}

		else if (newtender == 4) {
			StateGovtOfficer stateGovtOfficer = new StateGovtOfficer();
			System.out.println("enter title of tender which you want to delete");
			String delete_title = sc.next();

			stateGovtOfficer.deleteTender(tender_list, delete_title);

		}

	}

}
