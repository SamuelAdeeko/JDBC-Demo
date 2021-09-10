package com.jdbc.controller;

import java.util.ArrayList;
import java.util.List;

import com.jdbc.DAO.Impl.RegistrationDAOImpl;
import com.jdbc.model.Registration;

public class RegistrationController {

	
	

	
	public static void main(String[] args) throws Exception {
		
		RegistrationDAOImpl registrationDAOImpl = new RegistrationDAOImpl();
		
		// Register user
//		Registration registration = new Registration("James", "Cole", 7777777178l, "james@yahoo.com", "California");
//		int number = registrationDAOImpl.saveRegistration(registration);
//		System.out.println("Result: " + number);
		
		List<Registration> allRegistration = new ArrayList<>();
		allRegistration= registrationDAOImpl.findAllRegistration();
		
		for(Registration r: allRegistration) {
			System.out.println(r);
		}
		
	}
}
