package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Playlist;
import com.example.demo.repository.PlaylistRepository;

@Service
public class PlaylistServiceImplementation implements PlaylistService{

	@Autowired
	PlaylistRepository prepo;
	
	@Override
	public void addPlaylist(Playlist pList) {
		prepo.save(pList);
			
	}
	
	@Override
	public List<Playlist> fetchPlaylist() {
		return prepo.findAll();
	}

}
