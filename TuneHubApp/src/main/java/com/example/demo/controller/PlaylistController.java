package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Playlist;
import com.example.demo.entity.Song;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.SongService;

@Controller
public class PlaylistController {

	@Autowired
	SongService songserv;
	@Autowired
	PlaylistService pserv;
	
	@GetMapping("/createplaylist")
	public String createPlaylist(Model model) {
		List<Song> songList = songserv.viewSong();
		model.addAttribute("songs",songList);
		return "createplaylist";
	}
	
	@PostMapping("/addplaylist")
	public String addPlaylist(Playlist pList) {
		pserv.addPlaylist(pList);
		List<Song> songList = pList.getSong();
		
		for(Song song:songList) {
			song.getPlaylist().add(pList);
			songserv.updateSong(song);
		}
		return "playlistsuccess";
	}
	
	@GetMapping("/viewplaylist")
	public String viewPlaylist(Model model) {
		List<Playlist> pList = pserv.fetchPlaylist();
		model.addAttribute("playlist",pList);
		return "viewPlaylist";
	}

}
