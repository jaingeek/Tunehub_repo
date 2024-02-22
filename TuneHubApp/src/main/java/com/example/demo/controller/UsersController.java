package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Song;
import com.example.demo.entity.Users;
import com.example.demo.services.SongService;
import com.example.demo.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {

	@Autowired
	UsersService userserv;
	@Autowired
	SongService songserv;
	
	@PostMapping("/register")
	// Method for adding user in database
	public String addUser(@ModelAttribute Users user) {
		// Invoking emailExists() for checking whether email already exist or not
		boolean userstatus = userserv.emailExists(user.getEmail()); 
		
		//If email doesn't exists
		if(userstatus == true) {
			userserv.addUser(user);
			return "registerationsuccess";
		}
		//Else email exists
		else {
			return "registerationfail";
		}
	}
	
	@PostMapping("/login")
	//Method for checking the email and password entered by user is correct or not
	public String validateUser(@RequestParam String email,@RequestParam String password,HttpSession session) {
		
		boolean loginstatus = userserv.validateUser(email,password);
		session.setAttribute("email",email);
		// If email and password are correct 
		if(loginstatus==true) {
			//Invoking userRole() for retrieving the role whether it is admin or customer
			if(userserv.userRole(email).equals("admin")) return "adminhome";
			else return "customerhome";
		}
		else return "loginfail";
	}
	
	@GetMapping("/exploreSongs")
	public String exploreSongs(HttpSession session,Model model) {
		String email = (String)session.getAttribute("email");
		
		if(email==null) return "login";
		
		Users user = userserv.getUser(email);
		
		boolean userStatus = user.isPremium();
		if(userStatus == true) {
			List<Song> songList = songserv.viewSong();
			model.addAttribute("songs",songList);
			return "viewsong";
		}
		else return "samplePayment";
	}
}
