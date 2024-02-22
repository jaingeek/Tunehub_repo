package com.example.demo.services;

import com.example.demo.entity.Users;

public interface UsersService {
	public String addUser(Users user);
	public boolean emailExists(String email);
	public boolean validateUser(String email,String password);
	public String userRole(String email);
	public Users getUser(String email);
	public void update(Users user);
}
