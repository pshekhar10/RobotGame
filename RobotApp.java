/*
 * This class represents a visual application for the "robot chase" game.
 */
package robotapp;

/**
 *
 * @author jrsullins
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RobotApp extends JFrame implements ActionListener {

    // Member variables for visual objects.
    private JLabel[][] board; // 2D array of labels. Displays either # for player,
                              // * for pod, or empty space
    private JButton northButton, // player presses to move up
                    southButton, // player presses to move down
                    eastButton,  // player presses to move right
                    westButton;  // player presses to move left
    
    // Current width and height of board (will make static later).
    private int width = 15;
    private int height = 15;
    
    // Player object
    // Uncomment once you have created the Player class
    Player player;
    
    
    // Pod object stored in array for efficiency
    //Uncomment once you have created the Robot class
    private Robot[] robots;
    
    int robotCount = 3;
    
    public RobotApp() {
        
        // Construct a panel to put the board on and another for the buttons
        JPanel boardPanel = new JPanel(new GridLayout(height, width));
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
        
        // Use a loop to construct the array of labels, adding each to the
        // board panel as it is constructed. Note that we create this in
        // "row major" fashion by making the y-coordinate the major 
        // coordinate. We also make sure that increasing y means going "up"
        // by building the rows in revers order.
        board = new JLabel[height][width];
        for (int y = height-1; y >= 0; y--) {
            for (int x = 0; x < width; x++) {
                
                // Construct a label to represent the tile at (x, y)
                board[y][x] = new JLabel(" ", JLabel.CENTER);
                
                // Add it to the 2D array of labels representing the visible board
                boardPanel.add(board[y][x]);
            }
        }
        
        // Construct the buttons, register to listen for their events,
        // and add them to the button panel
        northButton = new JButton("N");
        southButton = new JButton("S");
        eastButton = new JButton("E");
        westButton = new JButton("W");
        
        // Listen for events on each button
        northButton.addActionListener(this);
        southButton.addActionListener(this);
        eastButton.addActionListener(this);
        westButton.addActionListener(this);
        
        // Add each to the panel of buttons
        buttonPanel.add(northButton); 
        buttonPanel.add(southButton); 
        buttonPanel.add(eastButton); 
        buttonPanel.add(westButton);
        
        // Add everything to a main panel attached to the content pane
        JPanel mainPanel = new JPanel(new BorderLayout());
        getContentPane().add(mainPanel);
        mainPanel.add(boardPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Size the app and make it visible
        setSize(300, 350);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Auxiliary method to create game setup
        createGame();
    }
    
    // Auxiliary method used to create board. Sets player, treasure, and walls.
    public void createGame() {
        
        // Uncomment once you have created the Player class 
        player = new Player(7, 1, width, height);
        
        
        // Uncomment once you have created the Robot class 
        // Construct array of Robot objects
        robots = new Robot[robotCount];
        
        // Construct each Robot in the array, passing it its initial location,
        // fuel, and a reference to the Player.
        robots[0] = new Robot(7, 12, 8, player);
        robots[1] = new Robot(3, 10, 12, player);
        robots[2] = new Robot(10, 10, 10, player);
        
        
        // Call method to draw board
        drawBoard();
        
    }
    
    // Auxiliary method to display player and robots in labels.
    public void drawBoard() {
        
        // "Erase" previous board by writing " " in each label
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                board[y][x].setText(" ");
            }
        }
        
        // Uncomment once you have created the Robot class 
        // Get location of each robot and write # into that label (if not exploded). 
        for (int p = 0; p < robotCount; p++) {
            if (!robots[p].isExploded()) {
                board[robots[p].getY()][robots[p].getX()].setText("#");
            }
        }
        
        
        //Uncomment once you have created the Player class 
        // Write the player onto the board.
        board[player.getY()][player.getX()].setText("P");
        
    }
    
    
    public void actionPerformed(ActionEvent e) {
        
        // Determine which button was pressed, and move player in that
        // direction (making sure they don't leave the board).
        
        // Uncomment once you have created the Player class
        if (e.getSource() == southButton) {
            player.move("south");
        }
        if (e.getSource() == northButton) {
            player.move("north");
        }
        if (e.getSource() == eastButton) {
            player.move("east");
        }
        if (e.getSource() == westButton) {
            player.move("west");
        }
        
        
        // Uncomment once you have created the Robot class
        // Move the pods and notify the pods about player location. Also invoke
        // method for random m direction changes.
        for (int p = 0; p < robotCount; p++) {
            robots[p].move();
        }
        
        
        // Redraw the board
        drawBoard();
        
        //Uncomment once you have created the Player class
        if (player.getY() >= height-1) {
            gameOver();
        }
        
    }
    
    public void gameOver() {
        //Uncomment once you have created the Player class
        JOptionPane.showMessageDialog(this, "Reached exit with "+player.getHits()+ " hits");
        
        northButton.setEnabled(false);
        southButton.setEnabled(false);
        eastButton.setEnabled(false);
        westButton.setEnabled(false);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RobotApp a = new RobotApp();
    }
}