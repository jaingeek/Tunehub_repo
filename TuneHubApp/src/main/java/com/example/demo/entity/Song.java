package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Song {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String songName;
	String songArtist;
	String songGenre;
	String songLink;
	
	@ManyToMany
	List<Playlist> playlist;

	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Song(int id, String songName, String songArtist, String songGenre, String songLink,
			List<Playlist> playlist) {
		super();
		this.id = id;
		this.songName = songName;
		this.songArtist = songArtist;
		this.songGenre = songGenre;
		this.songLink = songLink;
		this.playlist = playlist;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSongArtist() {
		return songArtist;
	}

	public void setSongArtist(String songArtist) {
		this.songArtist = songArtist;
	}

	public String getSongGenre() {
		return songGenre;
	}

	public void setSongGenre(String songGenre) {
		this.songGenre = songGenre;
	}

	public String getSongLink() {
		return songLink;
	}

	public void setSongLink(String songLink) {
		this.songLink = songLink;
	}

	public List<Playlist> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(List<Playlist> playlist) {
		this.playlist = playlist;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", songName=" + songName + ", songArtist=" + songArtist + ", songGenre=" + songGenre
				+ ", songLink=" + songLink + "]";
	}
	
	
}
