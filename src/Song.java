import javazoom.jl.player.Player;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Song {
    
    private String name;
    private String artist;
    private String filepath;
    private Player player;
    private Thread playerThread;

    public Song(String filepath, String artist, String name){
        this.name = name;
        this.artist = artist;
        this.filepath = filepath;
    }

    public void play() {
        try {
            FileInputStream fileInputStream = new FileInputStream(filepath);
            player = new Player(fileInputStream);

            // Create a thread to play the MP3
            playerThread = new Thread(() -> {
                try {
                    player.play();
                } catch (Exception e) {
                    System.out.println("Error playing MP3: " + e.getMessage());
                }
            });
            playerThread.start();

        } catch (FileNotFoundException e) {
            System.out.println("MP3 file not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error initializing MP3 player: " + e.getMessage());
        }
    }

    // Method to stop the song
    public void stop() {
        if (player != null) {
            player.close();  // Stops the player
        }
        if (playerThread != null && playerThread.isAlive()) {
            playerThread.interrupt();  // Interrupts the playback thread
        }
        //System.out.println("Stopped: " + name);
    }


    ///////////////////////////
    /// Setters and Getters 
    //////////////////////////
    
    public String getname(){
        return name;
    }

    public String getfilepath(){
        return filepath;
    }

    public void setname(String name){
        this.name = name;
    }

    public void setfilepath(String filepath){
        this.filepath = filepath;
    }

    public String getartist(){
        return artist;
    }

    public void setartist(String name){
        this.artist = artist;
    }

    // Override to String
    public String toString(){
        return name + " by " + artist;
    }

}
