package music.prakash.com.musicalstructureapp.utils;

public class Song {


    private String songname;
    private String artistname;
    private String albumname;

    public Song(String songname, String artistname, String albumname) {
        this.songname = songname;
        this.artistname = artistname;
        this.albumname = albumname;
    }

    @Override
    public String toString() {
        return "Song(" + songname + " By " +
                 artistname + " From " +
                 albumname + ')';
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public String getArtistname() {
        return artistname;
    }

    public void setArtistname(String artistname) {
        this.artistname = artistname;
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }



}
