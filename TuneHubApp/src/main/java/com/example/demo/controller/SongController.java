package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Song;
import com.example.demo.services.SongService;

@Controller
public class SongController {

	@Autowired
	SongService songserv;
	
	@PostMapping("/addsong")
	public String addSong(@ModelAttribute Song song) {
		boolean songstatus = songserv.validateSong(song.getSongName());
		
		if(songstatus==true) {
			songserv.addSong(song);
		}
		else {
			System.out.println("Song already exists");
		}
		return "addsong";
	}
	
	@GetMapping("/map-viewsong")
	public String viewSong(Model model) {
		boolean primeStatus = true;
		if(primeStatus == true) {
			List<Song> songList = songserv.viewSong();
			model.addAttribute("songs",songList);
			return "viewsong";
		}
		else return "makePayment";
	}
}
