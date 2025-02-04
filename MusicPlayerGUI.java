import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class MusicPlayerGUI extends JFrame {
    private JLabel songLabel;
    private JButton nextButton;
    private JButton shuffleButton;
    private JButton previousButton;
    private JButton addSongButton;
    private JButton removeSongButton;


    public MusicPlayerGUI() {

        //Create Songs
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
       
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
        songs.add(song5);
        songs.add(song6);
        songs.add(song7);
        songs.add(song8);
        songs.add(song9);
        songs.add(song10);
        songs.add(song11);
        songs.add(song12);

        //Create playlist
        Playlist playlist = new Playlist();

        // Add songs to playlist
        playlist.add(song1);
        playlist.add(song2);
        playlist.add(song3);

        playlist.displayPlaylist();

        //Start playlist
        playlist.startPlaylist();

        
        // Set up the GUI components with custom styles
        songLabel = new JLabel(playlist.getCurrentSong().toString(), SwingConstants.CENTER);
        songLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        songLabel.setForeground(Color.BLACK);
        
        // Define button size
        Dimension buttonSize = new Dimension(80, 80);

        // Load and scale images for buttons
        ImageIcon shuffleIcon = scaleImageIcon("shuffle.png", buttonSize.width - 30, buttonSize.height - 30);
        ImageIcon nextIcon = scaleImageIcon("forward.png", buttonSize.width - 20, buttonSize.height - 20);
        ImageIcon previousIcon = scaleImageIcon("back.png", buttonSize.width - 20, buttonSize.height - 20);

        // Create and style buttons with scaled images
        shuffleButton = new JButton("Shuffle", shuffleIcon);
        nextButton = new JButton("Next Song", nextIcon);
        previousButton = new JButton("Previous Song", previousIcon);
        addSongButton = new JButton("Add Song");
        removeSongButton = new JButton("Remove Song");
        

        Font buttonFont = new Font("SansSerif", Font.PLAIN, 14);

        shuffleButton.setFont(buttonFont);
        nextButton.setFont(buttonFont);
        previousButton.setFont(buttonFont);
        addSongButton.setFont(buttonFont);
        removeSongButton.setFont(buttonFont);

        // Set preferred size to make buttons uniform
        shuffleButton.setPreferredSize(buttonSize);
        nextButton.setPreferredSize(buttonSize);
        previousButton.setPreferredSize(buttonSize);
        addSongButton.setPreferredSize(new Dimension(160, 40));
        removeSongButton.setPreferredSize(new Dimension(160, 40));

        // Remove button borders and focus painting
        nextButton.setBorderPainted(false);
        previousButton.setBorderPainted(false);
        nextButton.setFocusPainted(false);
        previousButton.setFocusPainted(false);
        nextButton.setContentAreaFilled(false);
        previousButton.setContentAreaFilled(false); 
        shuffleButton.setBorderPainted(false);
        shuffleButton.setFocusPainted(false);
        shuffleButton.setContentAreaFilled(false);


        // Style buttons (colors and alignment)
        shuffleButton.setBackground(Color.WHITE); 
        shuffleButton.setForeground(Color.RED);
        nextButton.setBackground(Color.WHITE); 
        nextButton.setForeground(Color.RED);
        previousButton.setBackground(Color.WHITE); 
        previousButton.setForeground(Color.RED);

        addSongButton.setForeground(Color.BLACK);
        addSongButton.setBackground(Color.GRAY);
        addSongButton.setFocusPainted(false);

        removeSongButton.setForeground(Color.BLACK);
        removeSongButton.setBackground(Color.GRAY);
        removeSongButton.setFocusPainted(false);
        
        // Add action listeners for the buttons (logic left blank)
        nextButton.addActionListener(e -> {
            //System.out.println("next");
            playlist.nextSong();
            songLabel.setText(playlist.getCurrentSong().toString());
        });

        shuffleButton.addActionListener(e -> {
            System.out.println("\nPlaylist Shuffled\n");
            playlist.shuffle();
            songLabel.setText(playlist.getCurrentSong().toString());
            playlist.startPlaylist();
        });

        addSongButton.addActionListener(e -> {
            //System.out.println("add song");

            StringBuilder songList = new StringBuilder();
            int num = 1;
            for (Song song : songs){
                songList.append(String.valueOf(num) + ". " + song.toString() + "\n");
                num++;
            }

            ImageIcon icon = new ImageIcon("music.png");

            // Scale the image to fit the dialog (e.g., 100x100 pixels; adjust as needed)
            Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

            // Create a new ImageIcon from the scaled image
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            // String input = JOptionPane.showInputDialog(null, 
            // songList.toString() + "\nInput the number of the song you'd like to add.", 
            // "Remove Song", JOptionPane.PLAIN_MESSAGE, scaledIcon, null, "").toString();

            

                try{

                    String input = JOptionPane.showInputDialog(null, 
                    songList.toString() + "\nInput the number of the song you'd like to add.", 
                    "Remove Song", JOptionPane.PLAIN_MESSAGE, scaledIcon, null, "").toString();

                    if (!playlist.contains(songs.get(Integer.parseInt(input) - 1))){
                        boolean wasEmpty = playlist.isEmpty();

                        Song addedSong = songs.get(Integer.parseInt(input) - 1);

                        playlist.add(addedSong);

                        System.out.println("\n"+ addedSong.getname() + " added.\n");

                        if (wasEmpty) {
                            playlist.startPlaylist(); // Start playing if it was the first song added
                        }
                        
                    }else {
                        System.out.println("\nAlready part of playlist\n");
                    }
                }catch (Exception E){
                    System.out.println("\nInvalid Input. Song is not part of playlist.\n");
                }

                songLabel.setText(playlist.getCurrentSong().toString());

                playlist.displayPlaylist();
        });

        removeSongButton.addActionListener(e -> {
            //System.out.println("remove song");

            if (!playlist.isEmpty()){

                ImageIcon icon = new ImageIcon("music.png");

                // Scale the image to fit the dialog (e.g., 100x100 pixels; adjust as needed)
                Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

                // Create a new ImageIcon from the scaled image
                ImageIcon scaledIcon = new ImageIcon(scaledImage);

                // String input = JOptionPane.showInputDialog(null, 
                // playlist.toString() + "\nInput the number of the song you'd like to remove.", 
                // "Remove Song", JOptionPane.PLAIN_MESSAGE, scaledIcon, null, "").toString();


                //String input = JOptionPane.showInputDialog(playlist.toString() + "\nInput the number of the song you'd like to remove. ");

                try{

                    String input = JOptionPane.showInputDialog(null, 
                    playlist.toString() + "\nInput the number of the song you'd like to remove.", 
                    "Remove Song", JOptionPane.PLAIN_MESSAGE, scaledIcon, null, "").toString();

                    playlist.remove(Integer.parseInt(input) - 1);
                }catch (Exception E){
                    System.out.println("Invalid Input");
                }

                if (playlist.getCurrentSong() != null){
                    songLabel.setText(playlist.getCurrentSong().toString());
                }else{
                    songLabel.setText("\nEmpty Playlist :(\n");
                }

                playlist.displayPlaylist();
            }
        });

        previousButton.addActionListener(e -> {
            //System.out.println("previous");
            playlist.previousSong();
            songLabel.setText(playlist.getCurrentSong().toString());
        });

        // Create top panel for add/remove buttons
        JPanel topButtonPanel = new JPanel();
        topButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        topButtonPanel.setBackground(Color.RED);
        topButtonPanel.add(addSongButton);
        topButtonPanel.add(removeSongButton);

        // Panel for buttons and styling
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBackground(Color.RED);
        buttonPanel.add(previousButton);
        buttonPanel.add(shuffleButton);
        buttonPanel.add(nextButton);

        // Main layout
        setLayout(new BorderLayout());
        add(songLabel, BorderLayout.NORTH);
        add(topButtonPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set up the JFrame
        setTitle("Music Player");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        getContentPane().setBackground(Color.RED); // Snow white background
    }

    // Method to scale an ImageIcon
    private ImageIcon scaleImageIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
}

