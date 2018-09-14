package music.prakash.com.musicalstructureapp.utils;

import java.util.Arrays;

public class PlayList {
    public String getPlaylistname() {
        return playlistname;
    }

    public void setPlaylistname(String playlistname) {
        this.playlistname = playlistname;
    }

    private String playlistname;
    private Song[] songs;

    public PlayList(String playlistname, Song[] songs) {
        this.playlistname = playlistname;
        this.songs = songs;
    }

    public PlayList(String playlistname) {
        this.playlistname = playlistname;
    }

    @Override
    public String toString() {
        return  playlistname;
    }

    public Song[] getSongs() {
        return songs;
    }

    public void setSongs(Song[] songs) {
        this.songs = songs;
    }
}
