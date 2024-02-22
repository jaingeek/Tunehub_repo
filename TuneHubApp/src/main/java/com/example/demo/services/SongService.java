package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Song;

public interface SongService {

	public String addSong(Song song);
	public boolean validateSong(String songName);
	public List<Song> viewSong();
	public void updateSong(Song song);
}
