package music.prakash.com.musicalstructureapp.utils;

import java.util.Arrays;

public class Album {
    private String albumname;

    public Album(String albumname, Song[] songs) {
        this.albumname = albumname;
        this.songs = songs;
    }

    public Album(String albumname) {
        this.albumname = albumname;
    }

    @Override
    public String toString() {
        return  albumname;
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public Song[] getSongs() {
        return songs;
    }

    public void setSongs(Song[] songs) {
        this.songs = songs;
    }

    private Song[] songs;
}
