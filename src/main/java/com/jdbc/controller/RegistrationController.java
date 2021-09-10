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
		
		// get all registration
//		List<Registration> allRegistration = new ArrayList<>();
//		allRegistration= registrationDAOImpl.findAllRegistration();
//		
//		for(Registration r: allRegistration) {
//			System.out.println(r);
//		}
		
		// UPDATE phone Number by id
//		int result = registrationDAOImpl.updatePhoneNumberById(2, 5105630847l);
//		System.out.println("result: "+ result);
		
		int result1 = registrationDAOImpl.deleteByEmail("marty@yahoo.com");
		System.out.println(result1);
	}
}
