// Imports
import java.util.ArrayList;
import java.util.Collections;
import java.lang.StringBuilder;

//Plalist Class
public class Playlist {
    //Variables
    private Node head;
    private Node tail;
    private Node current;

    /**
     * Constructs a Playlist and sets head, tail, and current to null.
     * Empty list.
     * 
     */
    public Playlist(){
        this.head = null;
        this.tail = null;
        this.current = null;
    }

    /**
     * adds a new song to the playlist
     * 
     * @param song is the song added to the playlist
     */
    public void add(Song song){
        Node newSong = new Node(song);
        if (head == null){
            head = newSong;
            tail = newSong;
        }else{
            tail.setNext(newSong);
            newSong.setPrevious(tail);
            tail = newSong;
        }

        //System.out.println("\n"+ newSong.getSong().getname() + " added.\n");
    }

    /**
     * removes a song from the playlist using the index of the song
     * 
     * @param index is the index of the song that will be removed
     */
    public void remove(int index) {

        // Empty playlist or invalid index
        if (index < 0 || head == null) {
            System.out.println("Invalid index or empty playlist.");
            return;
        }
    
        Node node = head;
        int currentIndex = 0;
    
        // Traverse the list to find the node at the parameter index
        while (node != null && currentIndex < index) {
            node = node.getNext();
            currentIndex++;
        }

        Node removedNode = node;

        // If the node to remove is the current song, stop it before removing
        if (node == current) {
            current.getSong().stop(); // Stop the current song

            // Move current to the next song. If it is the last song, previosu song is played.
            if (current.getNext() != null) {
                current = current.getNext();
                current.getSong().play();
            } else if (current.getPrevious() != null) {
                current = current.getPrevious();
                current.getSong().play();
            } else {
                current = null; // Playlist will be empty after removal
            }
        }
    
        // Update links to remove the node at the specified index
        if (node == head) {
            head = node.getNext();
        }
        if (node == tail) {
            tail = node.getPrevious();
        }
        if (node.getPrevious() != null) {
            node.getPrevious().setNext(node.getNext());
        }
        if (node.getNext() != null) {
            node.getNext().setPrevious(node.getPrevious());
        }
    

    
        System.out.println("\n"+ removedNode.getSong().getname() + " removed.\n");
    }
    

    public void remove(Song song){
        Node compareNode = head;

        while(compareNode != null){
            if (compareNode.getSong().equals(song)){
                if (compareNode == head){
                    head = compareNode.getNext();
                }
                if (compareNode == tail){
                    tail = compareNode.getPrevious();
                }
                if (compareNode.getPrevious() != null) {
                    compareNode.getPrevious().setNext(compareNode.getNext());
                }
                if (compareNode.getNext() != null) {
                    compareNode.getNext().setPrevious(compareNode.getPrevious());
                }
                if (compareNode == current) {
                    current = head; // Reset current to head if we removed the current song
                }
                break;
            }
            compareNode = compareNode.getNext();
        }
    }

    public void shuffle(){

        if (current != null){
            current.getSong().stop();
        }
        
        if (head == null){
            return; // empty playlist
        }

        ArrayList<Node> playlistAL = new ArrayList<Node>();
        Node node = head;

        while (node != null){
            playlistAL.add(node);
            node = node.getNext();
        }
        
        Collections.shuffle(playlistAL);

        head = playlistAL.get(0);
        head.setPrevious(null);

        for (int i = 0; i < playlistAL.size() - 1; i++){
            current = playlistAL.get(i);
            Node next = playlistAL.get(i + 1);
            current.setNext(next);
            next.setPrevious(current);
        }

        // Update tail and set the next of the last node to null
        tail = playlistAL.get(playlistAL.size() - 1);
        tail.setNext(null);

        // Reset the current node to head
        current = head;


        displayPlaylist();
    }

    // Start the playlist at the head
    public void startPlaylist() {
        current = head;
        current.getSong().play();
    }

    // Move to the next song in the playlist
    public void nextSong() {
        if (current != null && current.getNext() != null) {
            current.getSong().stop();
            current = current.getNext();
            current.getSong().play();
        } else {
            System.out.println("End of playlist reached.");
        }
    }

    // Move to the previous song in the playlist
    public void previousSong() {
        if (current != null && current.getPrevious() != null) {
            current.getSong().stop();
            current = current.getPrevious();
            current.getSong().play();
        } else {
            System.out.println("Start of playlist reached.");
        }
    }

    // Get the current song
    public Song getCurrentSong() {
        return current != null ? current.getSong() : null;
    }

    // Check if the playlist is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Display all songs in the playlist
    public void displayPlaylist() {
        int num = 1;
        Node node = head;

        System.out.println("Current Playlist:");
        while (node != null) {
            System.out.println(num + ". " + node.getSong().getname());
            node = node.getNext();
            num++;
        }
    }

    public boolean contains(Song song) {
        Node node = head;
        
        while (node != null) {
            if (node.getSong().equals(song)) {
                return true; // Song found
            }
            node = node.getNext();
        }
        
        return false; // Song not found
    }

    // Display all songs in the playlist
    public String toString() {
        StringBuilder output = new StringBuilder();
        int num = 1;
        Node node = head;
        while (node != null) {
            output.append(num + ". " + node.getSong().getname() + "\n");
            node = node.getNext();
            num++;
        }

        return output.toString();
    }
}
