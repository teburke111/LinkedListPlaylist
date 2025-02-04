/**
 * Test class created by Mohamed Mohamed.
 * Tests the functionality of the double linked list Music Player by Thomas Bruke
 */

public class Tester_MohamedMohamed {

    public static void main(String[] args) {
        Playlist playlist = new Playlist();

        //Add 12 nodes
        Song song1 = new Song("song1.mp3", "ACDC", "ThunderStruck");
        Song song2 = new Song("song2.mp3", "ACDC", "Back In Black");
        Song song3 = new Song("song3.mp3", "ACDC", "Highway to Hell");
        Song song4 = new Song("song4.mp3", "Bon Jovi", "Livin' On A Prayer");
        Song song5 = new Song("song5.mp3", "Bon Jovi", "It's My Life");
        Song song6 = new Song("song6.mp3", "Bon Jovi", "Runaway");
        Song song7 = new Song("song7.mp3", "Nirvana", "Smells Like Teen Spirit");
        Song song8 = new Song("song8.mp3", "Nirvana", "Come as You Are");
        Song song9 = new Song("song9.mp3", "Nirvana", "You Know You're Right");
        Song song10 = new Song("song10.mp3", "Motley Crue", "Kickstart My Heart");
        Song song11 = new Song("song11.mp3", "Motley Crue", "Wild Side");
        Song song12 = new Song("song12.mp3", "Motley Crue", "Girls Girls Girls");

        //Track the results of the tests. If this ever turns false then autograder fails
        boolean allTestsPassed = true;

        //Add nodes
        try {
            playlist.add(song1);
            playlist.add(song2);
            playlist.add(song3);
            playlist.add(song4);
            playlist.add(song5);
            playlist.add(song6);
            playlist.add(song7);
            playlist.add(song8);
            playlist.add(song9);
            playlist.add(song10);
            playlist.add(song11);
            playlist.add(song12);
            System.out.println("Adding songs: SUCCESS");
        } catch (Exception e) {
            System.out.println("Adding songs: FAILED");
            allTestsPassed = false;
        }

        //Remove nodes
        try {
            playlist.remove(3); //Remove "Livin' On A Prayer"
            playlist.remove(0); //Remove "ThunderStruck"
            playlist.remove(song6); //Remove "Runaway"
            System.out.println("Removing songs: SUCCESS");
        } catch (Exception e) {
            System.out.println("Removing songs: FAILED");
            allTestsPassed = false;
        }

        //Test shuffle
        try {
            playlist.shuffle();
            System.out.println("Shuffling playlist: SUCCESS");
        } catch (Exception e) {
            System.out.println("Shuffling playlist: FAILED");
            allTestsPassed = false;
        }

        //Test playback
        try {
            playlist.startPlaylist(); //Play the first song
            playlist.nextSong();      //Move to the next song
            playlist.previousSong();  //Move back to the previous song
            System.out.println("Playback test: SUCCESS");
        } catch (Exception e) {
            System.out.println("Playback test: FAILED");
            allTestsPassed = false;
        }

        //Final check if the playlist contains a specific song
        try {
            if (playlist.contains(song12)) {
                System.out.println("Playlist contains test (Girls Girls Girls): SUCCESS");
            } else {
                System.out.println("Playlist contains test (Girls Girls Girls): FAILED");
                allTestsPassed = false;
            }
        } catch (Exception e) {
            System.out.println("Playlist contains test: FAILED");
            allTestsPassed = false;
        }

        //Final result
        System.out.println("\nFinal Test Result: " + (allTestsPassed ? "ALL TESTS PASSED" : "SOME TESTS FAILED"));
    }
}
