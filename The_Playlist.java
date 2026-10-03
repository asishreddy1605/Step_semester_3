import java.util.Arrays;

// Playlist.java
public class Playlist {
    private String[] songs;
    private int count;

    public Playlist(int capacity) {
        this.songs = new String[capacity];
        this.count = 0;
    }

    // Adds a song to the playlist if space is available
    public void addSong(String song) {
        if (count < songs.length) {
            songs[count] = song;
            count++;
        }
    }

    // Returns a defensive copy containing only the added songs
    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    // Returns the current number of songs in the playlist
    public int getSongCount() {
        return this.count;
    }
}

// Main.java (Driver class for testing)
public class The_Playlist {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        
        p.addSong("Song A");
        p.addSong("Song B");

        System.out.println("Song count: " + p.getSongCount()); // 2

        // Retrieve copy of songs
        String[] copy = p.getSongs();
        
        // Modify the returned array copy
        copy[0] = "Hacked";

        // Verify that original internal list remains unchanged
        System.out.println("Returned array index 0: " + copy[0]);               // "Hacked"
        System.out.println("Playlist internal index 0: " + p.getSongs()[0]);    // "Song A"
    }
}