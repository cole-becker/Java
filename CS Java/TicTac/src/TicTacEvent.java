import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 File Name:	TicTac
Programmer:	Cole Becker
Date:		April 3rd 2024
Purpose:        To modify the existing tic tac toe program and add a score count panel,
                a way to restart, and change some personalization options.

 */

public class TicTacEvent implements ItemListener, ActionListener, Runnable { //creates a class that responds to mouse and keyboard input by “listening.”
    TicTac gui; //associates the game board with the event.
  
    ImageIcon a = new ImageIcon("x2.jpg"); //sets x2.jpg to imageicon a, make sure the images are less than 100x100 pixels in size
    ImageIcon b = new ImageIcon("o2.jpg"); //sets 02.jpg to imageicon b
    ImageIcon back = new ImageIcon("cardback.jpg");
    int clicks = 0;  //checks the number of turns 
    int win = 0;   //created to check for a winner
    int[][] check = new int[3][3];  //2D array to check the value in each box 
    int xWinCount, oWinCount, tieCount; // create all integer variables for keeping track off wins and ties
    JLabel xWinsLabel, oWinsLabel, tiesLabel;

    public TicTacEvent (TicTac in){ //associates the two files to be used together.
        gui = in;
        
        JPanel countPanel = new JPanel(new FlowLayout()); // create new panel for game counts with gridlayout with 3 rows and 3 columns
        countPanel.setBackground(Color.BLACK); // sets jlabel background to black
        gui.add(countPanel); // add Jpanel to gui
        xWinsLabel = new JLabel("X Wins: 0 |"); // create Jlabel's for all counts
        xWinsLabel.setForeground(Color.WHITE); // change color of text to pink for all label counts
        xWinsLabel.setFont(new Font("Arial", Font.PLAIN, 20)); // change font and size of text for all label counts
        oWinsLabel = new JLabel("O Wins: 0 |");
        oWinsLabel.setForeground(Color.WHITE);
        oWinsLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        tiesLabel = new JLabel("Ties: 0");
        tiesLabel.setForeground(Color.WHITE);
        tiesLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        countPanel.add(xWinsLabel); // add all labels to jpanel
        countPanel.add(oWinsLabel);
        countPanel.add(tiesLabel);
        for (int row=0; row<=2; row++){  //initiates the winner check array.
           for (int col=0; col<=2; col++){
               check[row][col]=0;
           }
       }
    }

    public void actionPerformed (ActionEvent event) {  //Tells the program what to do when a button is clicked.
       String command = event.getActionCommand();  //takes the button name as input from the button that is clicked.

       if (command.equals("1")) {  //if button labelled 1 is pressed 
           b1();                    //run the b1() method code below
       }
       if (command.equals("2")) {
           b2();
       }
       if (command.equals("3")) {
           b3();
       }
       if (command.equals("4")) {
           b4();
       }
       if (command.equals("5")) {
           b5();
       }
       if (command.equals("6")) {
           b6();
       }
       if (command.equals("7")) {
           b7();
       }
       if (command.equals("8")) {
           b8();
       }
       if (command.equals("9")) {
           b9();
       }
    }

void b1() {  //create methods b1 to b9 to handle clicks on Each game square
        clicks = clicks + 1;  //keeps track of the number of boxes chosen.
        if ((clicks%2)==1){  
            check[0][0] = 1; //if box in array position [0][0] top left corner is pressed 
            gui.boxes[0][0].setEnabled(false); //disable the box, so it can't be pressed again
            gui.boxes[0][0].setDisabledIcon(a); //set the image of the disabled box to a(X.jpg)
        } else {         // puts an O on the board and declares that square to be taken.
            check[0][0] = 2;
            gui.boxes[0][0].setEnabled(false); 
            gui.boxes[0][0].setDisabledIcon(b);
        }
        winner();

    }
    void b2() {
        clicks = clicks + 1;
        if ((clicks%2)==1){
            check[0][1] = 1;
            gui.boxes[0][1].setEnabled(false); 
            gui.boxes[0][1].setDisabledIcon(a);
        } else {
            check[0][1] = 2;
            gui.boxes[0][1].setEnabled(false); 
            gui.boxes[0][1].setDisabledIcon(b);
        }
        winner();
    }
    void b3() {
        clicks = clicks + 1;
        if ((clicks%2)==1){
            check[0][2] = 1;
            gui.boxes[0][2].setEnabled(false); 
            gui.boxes[0][2].setDisabledIcon(a);
        } else {
            check[0][2] = 2;
            gui.boxes[0][2].setEnabled(false); 
            gui.boxes[0][2].setDisabledIcon(b);
        }
        winner();
    }
    void b4() {
        clicks = clicks + 1;
        if ((clicks%2)==1){
            check[1][0] = 1;
            gui.boxes[1][0].setEnabled(false); 
            gui.boxes[1][0].setDisabledIcon(a);
        } else {
            check[1][0] = 2;
            gui.boxes[1][0].setEnabled(false); 
            gui.boxes[1][0].setDisabledIcon(b);
        }
        winner();
    }
    void b5() {
        clicks = clicks + 1;
        if ((clicks%2)==1){
            check[1][1] = 1;
            gui.boxes[1][1].setEnabled(false); 
            gui.boxes[1][1].setDisabledIcon(a);
        } else {
            check[1][1] = 2;
            gui.boxes[1][1].setEnabled(false); 
            gui.boxes[1][1].setDisabledIcon(b);
        }
        winner();
    }
    void b6() {
        clicks = clicks + 1;
        if ((clicks%2)==1){
            check[1][2] = 1;
            gui.boxes[1][2].setEnabled(false); 
            gui.boxes[1][2].setDisabledIcon(a);
        } else {
            check[1][2] = 2;
            gui.boxes[1][2].setEnabled(false); 
            gui.boxes[1][2].setDisabledIcon(b);
        }
        winner();
    }
    void b7() {
        clicks = clicks + 1;
        if ((clicks%2)==1){
            check[2][0] = 1;
            gui.boxes[2][0].setEnabled(false); 
            gui.boxes[2][0].setDisabledIcon(a);
        } else {
            check[2][0] = 2;
            gui.boxes[2][0].setEnabled(false); 
            gui.boxes[2][0].setDisabledIcon(b);
        }
        winner();
    }
    void b8() {
        clicks = clicks + 1;
        if ((clicks%2)==1){
            check[2][1] = 1;
            gui.boxes[2][1].setEnabled(false); 
            gui.boxes[2][1].setDisabledIcon(a);
        } else {
            check[2][1] = 2;
            gui.boxes[2][1].setEnabled(false); 
            gui.boxes[2][1].setDisabledIcon(b);
        }
        winner();
    }
    void b9() {
        clicks = clicks + 1;
        if ((clicks%2)==1){
            check[2][2] = 1;
            gui.boxes[2][2].setEnabled(false); 
            gui.boxes[2][2].setDisabledIcon(a);
        } else {
            check[2][2] = 2;
            gui.boxes[2][2].setEnabled(false); 
            gui.boxes[2][2].setDisabledIcon(b);
        }
        winner();
    }

    void winner() {
        /** Check rows for winner */
        
        for (int x=0; x<=2; x++){  // checks each row
            if ((check[x][0]==check[x][1])&&(check[x][0]==check[x][2])) { //checks to see if all entries are X, or all entries are O.
                if (check[x][0]==1) {  // if all X
                    JOptionPane.showMessageDialog(null, "X is the winner"); // creates a pop up box declaring a winner
                    win = 1;
                    xWinCount++; // increase x win
                    xWinsLabel.setText("X Wins: " + xWinCount + " |"); // update JLabel to correct win number with | after to divide scores
                    restartGame(); // calls restart game function to automatically restart once winner or tie
                  
                } else if (check[x][0]==2){  //if all O
                    JOptionPane.showMessageDialog(null, "O is the winner");
                    win = 1;
                    oWinCount++; // increase o win
                    oWinsLabel.setText("O Wins: " + oWinCount + " |"); // update win jlabels
                    restartGame(); // restart game automatically instead of reset button
                    
                }
            }
        }

        /** Check columns for winner */
        for (int x=0; x<=2; x++){  //checks each column
            if ((check[0][x]==check[1][x])&&(check[0][x]==check[2][x])) {  //checks to see if all entries are X, or all entries are O.
                if (check[0][x]==1) {
                    JOptionPane.showMessageDialog(null, "X is the winner");  //pop up box that declares the winner
                    win = 1;
                    xWinCount++;
                    xWinsLabel.setText("X Wins: " + xWinCount + " |"); // update JLabel to correct win number
                    restartGame();
                    
                    
                } else if (check[0][x]==2) {
                    JOptionPane.showMessageDialog(null, "O is the winner");
                    win = 1;
                    oWinCount++;
                    oWinsLabel.setText("O Wins: " + oWinCount + " |");
                    restartGame();
                   
                }
            }
        }

        /** Check diagonals for winner */
        if (((check[0][0]==check[1][1])&&(check[0][0]==check[2][2]))||
                ((check[2][0]==check[1][1])&&(check[1][1]==check[0][2]))){  //checks for diagonal matches.
            if (check[1][1]==1) {     //checks for X winner.

                JOptionPane.showMessageDialog(null, "X is the winner");
                win = 1;
                xWinCount++;
                xWinsLabel.setText("X Wins: " + xWinCount + " |"); // update JLabel to correct win number
                restartGame();
                
            } else if (check[1][1]==2) { //checks for O winner.

                JOptionPane.showMessageDialog(null, "O is the winner");
                win = 1;
                oWinCount++;
                oWinsLabel.setText("O Wins: " + oWinCount + " |");
                restartGame();
            }

        }

        /** Checks if the game is a tie */
        if ((clicks==9) && (win==0)) {   //This structure checks to see if nine boxes have been chosen (clicks) and that a winner has not been declared (win == 0). 
            JOptionPane.showMessageDialog(null, "The game is a tie");
            tieCount++; // Increase int ties when tied
            tiesLabel.setText("Ties: " + tieCount); // Update display to show correct ties
            restartGame();
        }
    }
    
    void restartGame() {
        for (int x = 0; x < 3;x++) {
            for (int y = 0; y < 3; y++) {
                check[x][y] = 0; // Reset check array
                gui.boxes[x][y].setEnabled(true); // Enable all buttons again
                gui.boxes[x][y].setIcon(back); // Clear button Icons back to cardback
            }
        }
        clicks = 0; // reset clicks counter
        win = 0; // reset win back to 0
    }

     
    //void startPlaying() {
      //  playing = new Thread(this);
       // playing.start();
       // gui.play.setEnabled(false);
    //}

    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
