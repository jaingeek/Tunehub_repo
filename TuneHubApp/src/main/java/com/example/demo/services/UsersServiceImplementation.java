package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersService{

	@Autowired
	UsersRepository urepo;
	
	@Override
	//Method for adding user
	public String addUser(Users user) {
		urepo.save(user);
		return "User object created and saved";
	}

	@Override
	//Method for checking email already exists or not
	public boolean emailExists(String email) {
		
		if(urepo.findByEmail(email) == null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	//Method for validating user
	public boolean validateUser(String email,String password) {
		Users user = urepo.findByEmail(email);
		if(user!=null) {
			//If email is correct
			String dbPassword = user.getPassword();
			if(dbPassword.equals(password)) {
				//If password is correct
				return true;
			}
			else return false;
		}
		else return false;
	}

	@Override
	//Method for getting role from database using email
	public String userRole(String email) {
		Users user = urepo.findByEmail(email);
		String role = user.getRole();
		return role;
	}

	@Override
	public Users getUser(String email) {
		return urepo.findByEmail(email);
	}

	@Override
	public void update(Users user) {
		// TODO Auto-generated method stub
		urepo.save(user);
		
	}
}
