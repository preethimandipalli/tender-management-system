package model;

import java.util.Scanner;

import businesslogic.RegisterationValidation;

public class UserRegistration {
	Scanner scanner = new Scanner(System.in);

	public User registerationDetails() {
		
		System.out.print(" Enter firstName => ");
        String fn = scanner.next();

        System.out.print(" Enter lastName => ");
        String lastName = scanner.next();

        System.out.print(" Enter userName => ");
        String userName = scanner.next();
        
        System.out.print(" Enter phoneNo => ");
        long phoneNo = scanner.nextLong();
      
        System.out.print(" Enter emailId => ");
        String emailId = scanner.next();
        
        System.out.print(" Enter password => ");
        String password = scanner.next();
        
        System.out.print(" confirm password => ");
        String confirmPassword = scanner.next();
        RegisterationValidation registerationValidation =new RegisterationValidation();
        if(registerationValidation.checkUserDetails(emailId,password,confirmPassword)==true) {
        	
        	return (new User(fn,lastName,userName,phoneNo,emailId,password,confirmPassword));
        	
        }else {
        	
        	return null;
        	
        }
		
		
		
		
				
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
