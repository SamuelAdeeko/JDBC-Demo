package com.jdbc.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.DAO.util.PostgresSQLConnection;
import com.jdbc.model.Registration;
import com.jdbc.repository.RegistrationRepo;

public class RegistrationDAOImpl implements RegistrationRepo {
	
	/*     SOME OF SQL COMMANDS USED
	 * 
	 * 
	 * ALTER TABLE Person ADD PRIMARY KEY(ID);
	 * 
	 * show databases;
	 * create database Players;
	 * create Table players.users(id int Not Null, name Varchar(255) Not Null, age int;
	 * desc Players.users;
	 * insert into Players.users values(1,'ABC', 30);
	 * SELECT * FROM Players.users;
	 * ALTER TABLE Players.users modify age int Not Null ;
	 * select id,name, team_id, age, gender, contact, dob from revaturetest.player";
	 * select name, team_id, age, gender, contact, dob from revaturetest.player where id = ? ";
	 * update revaturetest.player set contact = ? where id = ?" 
	 * DELETE FROM revaturetest.player WHERE id=?" 
*/
	@Override
	public int saveRegistration(Registration registration) throws Exception {
		
		int result = 0;
	
		try (Connection connection = PostgresSQLConnection.getConnection()){
			String sql = "insert into techbee.registration(first_name, last_name, "
					+ "phone_number, email, state) values (?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			// create the object to send to db
			preparedStatement.setString(1, registration.getFirstName());
			preparedStatement.setString(2, registration.getLastName());
			preparedStatement.setLong(3, registration.getPhoneNumber());
			preparedStatement.setString(4, registration.getEmail());
			preparedStatement.setString(5, registration.getState());
		
			
			result = preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new Exception("An error occured during registration");
		}
		return result;
		
	}

	@Override
	public List<Registration> findAllRegistration() throws Exception {
		
		List<Registration> allRegistration = new ArrayList<>();
		
		
		try (Connection connection = PostgresSQLConnection.getConnection()) {
			String sql = "SELECT * FROM techbee.registration";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			// user next() to get all record if more than one record id found
 			while(resultSet.next()) {
 				//create a new object 
 			Registration registration = new Registration();
			registration.setFirstName(resultSet.getString("first_name"));
			registration.setLastName(resultSet.getString("last_name"));
			registration.setPhoneNumber(resultSet.getLong("phone_number"));
			registration.setEmail(resultSet.getString("email"));
			registration.setState(resultSet.getString("state"));
			allRegistration.add(registration);
 			}
 			if(allRegistration.size() == 0) {
 				throw new Exception("No record found in the Database. Enter a new record.");
 			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new Exception("Error getting all registration records");
		} 
	
		return allRegistration;
	}

	@Override
	public Registration findByEmailAndPhoneNumber(String email, long phoneNumber) {

		try (Connection connection = PostgresSQLConnection.getConnection()){
			String sql = "select FROM techbee.registration WHERE email = ? AND phone_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}

	@Override
	public int updatePhoneNumberById(int id, long phoneNumber) throws Exception {
		int result = 0;
		
		try (Connection connection = PostgresSQLConnection.getConnection()){
			String sql = "update techbee.registration set phone_number = ? WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, phoneNumber);
			preparedStatement.setInt(2, id);
			result = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new Exception("User not found with Id " + id);
		}
		
		
		return result;
	}

	
	@Override
	public int deleteByEmail(String email) throws Exception  {
		int result = 0;
		
		try(Connection connection = PostgresSQLConnection.getConnection()) {
			String sql = "DELETE FROM techbee.registration WHERE email = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			
			result = preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new Exception("Error deleting record");
		}
		return result;
	}

}
