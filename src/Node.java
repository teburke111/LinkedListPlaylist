//NODE CLASS
public class Node {
    // Variables
    private Song song;
    private Node previous;
    private Node next;

    /**
     * Constructs a Node with a song
     * 
     * @param song song stored in the node
     */
    public Node (Song song){
        this.song = song;
        this.previous = null;
        this.next = null;
    }

    /**
     * Constructs a Node with a song, previous and next node
     * 
     * @param song song stored in the node
     * @param previous previous node
     * @param next next node
     */
    public Node (Song song, Node previous, Node next){
        this.song = song;
        this.previous = previous;
        this.next = next;
    }

    /**
     * returns song stored in node
     * 
     * @return song object
     */
    public Song getSong() {
        return song;
    }

    /**
     * Sets the song for the node
     * 
     * @param song is the song value for the node 
     */
    public void setSong(Song song) {
        this.song = song;
    }

    /**
     * returns next node
     * 
     * @return next node
     */
    public Node getNext() {
        return next;
    }

    /**
     * Sets the next node
     * 
     * @param next node is set as the next node
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * returns previous node 
     * 
     * @return previous node
     */
    public Node getPrevious() {
        return previous;
    }

    /**
     * Sets the previous node
     * 
     * @param previous the node that is set as the previous node
     */
    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    /**
     * ovverides tostring method and returns representation of node
     * 
     * @return string represenation of the song object in node
     */
    @Override
    public String toString(){
        return song.toString();
    }
 
}
