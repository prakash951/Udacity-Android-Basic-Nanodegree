package music.prakash.com.musicalstructureapp.utils;

import java.util.Arrays;

public class Artist {
    private String artistname;
    private Song[] songs;
    private Album[] albums;

    @Override
    public String toString() {
        return  artistname;
    }

    public String getArtistname() {
        return artistname;
    }

    public void setArtistname(String artistname) {
        this.artistname = artistname;
    }

    public Song[] getSongs() {
        return songs;
    }

    public Artist(String artistname, Song[] songs, Album[] albums) {
        this.artistname = artistname;
        this.songs = songs;
        this.albums = albums;
    }

    public void setSongs(Song[] songs) {
        this.songs = songs;
    }

    public Album[] getAlbums() {
        return albums;
    }

    public void setAlbums(Album[] albums) {
        this.albums = albums;
    }


}
