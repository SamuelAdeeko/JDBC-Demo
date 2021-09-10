package com.jdbc.repository;

import java.util.List;

import com.jdbc.model.Registration;

public interface RegistrationRepo {
	
	public int saveRegistration(Registration registration) throws Exception;
	public List<Registration> findAllRegistration() throws Exception;
	public Registration findByEmailAndPhoneNumber(String email, long phoneNumber);
	public Registration updateById(int id);
	public Registration updateByPhoneNumber(long phoneNumber);
	public boolean deleteByEmail(String email);

}
