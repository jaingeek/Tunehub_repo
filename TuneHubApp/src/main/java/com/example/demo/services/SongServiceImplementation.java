package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Song;
import com.example.demo.repository.SongRepository;

@Service
public class SongServiceImplementation implements SongService{

	@Autowired
	SongRepository songrepo;
	
	@Override
	public String addSong(Song song) {
		songrepo.save(song);
		return "song saved successfully";
	}

	@Override
	public boolean validateSong(String songName) {
		Song song = songrepo.findBySongName(songName);
		if(song==null) return true;
		else return false;
	}
	
	@Override
	public List<Song> viewSong() {
		return songrepo.findAll();
	}

	@Override
	public void updateSong(Song song) {
		// TODO Auto-generated method stub
		songrepo.save(song);
		
	}

}
