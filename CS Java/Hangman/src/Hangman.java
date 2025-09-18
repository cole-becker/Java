/**
File Name:	Hangman
Programmer:	Cole Becker
Date:		July 14th 2024
Purpose:        To create a game of hangman which scans a text file and puts words into a ArrayList to be played and is
*               easily updated for new words and themes.
 */

import java.io.File; // imports 
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Hangman extends javax.swing.JFrame {
    
    String secretWord = ""; // define variables
    ArrayList<String> words = new ArrayList<>();
    ArrayList guessedLetters = new ArrayList();
    int failedGuesses = 0;
    int wins = 0;
    int losses = 0;
    int points = 0;
    String temp = "";
      
    /**
     * Creates new form Hangman
     */
    public Hangman() {
        initComponents();
        nextBtn.setEnabled(false);
        File file = new File("words.txt"); // create file based on our file in directory
        try {
            Scanner scan = new Scanner(file); // create scanner for file
            while (scan.hasNextLine()){ // while there are words in txt file
                words.add(scan.nextLine()); // add them to arraylist
            }
            
        } catch (FileNotFoundException ex) { // catch file not found
            Logger.getLogger(Hangman.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        StringBuilder str = new StringBuilder(); // show welcome intruction screen when program opened
        str.append("                        ____________\n");
        str.append("                        |               |\n");
        str.append("                        |              O\n");
        str.append("                        |             /|\\");
        str.append("\n");
        str.append("                        |              /\\");
        str.append("\n");
        str.append("                    ___|___            \n");
        str.append("\n");
        str.append("               Made By: Cole Becker\n");
        str.append("            Click New Game to begin.");
        hangmanDisplaytxt.setText(str.toString());
    }
    
    public void scoreboardUpdate(int wins, int losses){ // create function for updating scoreboard
        winsOutput.setText("Wins: " + wins); // set output with up to date win/loss count
        lossesOutput.setText("Losses: " + losses);
    }
    
    public void scoreUpdate(int points){
        scoreOutput.setText("Score: " + points);
    }
    
    public void hangmanUpdate() {
        switch (failedGuesses) {
        case 1:
            StringBuilder str = new StringBuilder(); // 1 incorrect guess
            str.append("                        ____________\n");
            str.append("                        |               |\n");
            str.append("                        |               \n");
            str.append("                        |                ");
            str.append("\n");
            str.append("                        |              ");
            str.append("\n");
            str.append("                    ___|___            ");
            str.append("");
            hangmanDisplaytxt.setText(str.toString());
            break;
            
        case 2:
            StringBuilder str2 = new StringBuilder(); // 2 incorrect guess
            str2.append("                        ____________\n");
            str2.append("                        |               |\n");
            str2.append("                        |              O\n");
            str2.append("                        |             ");
            str2.append("\n");
            str2.append("                        |              ");
            str2.append("\n");
            str2.append("                    ___|___            ");
            str2.append("");
            hangmanDisplaytxt.setText(str2.toString());
            break;
            
        case 3:
            StringBuilder str3 = new StringBuilder(); // 3 incorrect guess
            str3.append("                        ____________\n");
            str3.append("                        |               |\n");
            str3.append("                        |              O\n");
            str3.append("                        |               |");
            str3.append("\n");
            str3.append("                        |              ");
            str3.append("\n");
            str3.append("                    ___|___            \n");
            str3.append("");
            hangmanDisplaytxt.setText(str3.toString());
            break;
            
        case 4:
            StringBuilder str4 = new StringBuilder(); // 4 incorrect guess
            str4.append("                        ____________\n");
            str4.append("                        |               |\n");
            str4.append("                        |              O\n");
            str4.append("                        |               |\\");
            str4.append("\n");
            str4.append("                        |              ");
            str4.append("\n");
            str4.append("                    ___|___            \n");
            str4.append("\n");
            str4.append("                      3 more lives.");
            hangmanDisplaytxt.setText(str4.toString());
            break;
            
        case 5:
            StringBuilder str5 = new StringBuilder(); // 5 incorrect guess
            str5.append("                        ____________\n");
            str5.append("                        |               |\n");
            str5.append("                        |              O\n");
            str5.append("                        |             /|\\");
            str5.append("\n");
            str5.append("                        |              ");
            str5.append("\n");
            str5.append("                    ___|___            \n");
            str5.append("\n");
            str5.append("                      2 more lives.");
            hangmanDisplaytxt.setText(str5.toString());
            break;
            
        case 6:
            StringBuilder str6 = new StringBuilder(); // 6 incorrect guess
            str6.append("                        ____________\n");
            str6.append("                        |               |\n");
            str6.append("                        |              O\n");
            str6.append("                        |             /|\\");
            str6.append("\n");
            str6.append("                        |               \\");
            str6.append("\n");
            str6.append("                    ___|___            \n");
            str6.append("\n");
            str6.append("                         Last life!");
            hangmanDisplaytxt.setText(str6.toString());
            break;
            
        case 7:
            StringBuilder str7 = new StringBuilder(); // 7 inccorect guess (lose)
            str7.append("                        ____________\n");
            str7.append("                        |               |\n");
            str7.append("                        |              O\n");
            str7.append("                        |             /|\\");
            str7.append("\n");
            str7.append("                        |              /\\");
            str7.append("\n");
            str7.append("                    ___|___            \n");
            str7.append("\n");
            str7.append("                Better luck next time.");
            hangmanDisplaytxt.setText(str7.toString());
            break;
            
    }
    }
    
    public void endScreen(){
        if (words.isEmpty()) { // if words arraylist is empty
            outputtxt.setText("Game Over!"); // set text to game over
            nextBtn.setEnabled(false); // disable buttons for error handling
            newGameBtn.setEnabled(false);
            guessBtn.setEnabled(false);
            StringBuilder str = new StringBuilder(); // show welcome intruction screen when program opened
            str.append("                        ____________\n");
            str.append("                        |               |\n");
            str.append("                        |              O\n");
            str.append("                        |             /|\\");
            str.append("\n");
            str.append("                        |              /\\");
            str.append("\n");
            str.append("                    ___|___            \n");
            str.append("                 No words remaining.");
            hangmanDisplaytxt.setText(str.toString()); // set text to no words left game over
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        hangmanDisplaytxt = new javax.swing.JTextArea();
        secretWordOutput = new javax.swing.JTextField();
        guesslabel = new javax.swing.JLabel();
        userInput = new javax.swing.JTextField();
        guessBtn = new javax.swing.JButton();
        newGameBtn = new javax.swing.JButton();
        closeGameBtn = new javax.swing.JButton();
        outputtxt = new javax.swing.JTextField();
        winsOutput = new javax.swing.JTextField();
        lossesOutput = new javax.swing.JTextField();
        nextBtn = new javax.swing.JButton();
        scoreOutput = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hangman Game");
        setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        hangmanDisplaytxt.setEditable(false);
        hangmanDisplaytxt.setBackground(new java.awt.Color(51, 51, 51));
        hangmanDisplaytxt.setColumns(20);
        hangmanDisplaytxt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        hangmanDisplaytxt.setForeground(new java.awt.Color(255, 255, 255));
        hangmanDisplaytxt.setRows(5);
        jScrollPane1.setViewportView(hangmanDisplaytxt);

        secretWordOutput.setEditable(false);
        secretWordOutput.setBackground(new java.awt.Color(51, 51, 51));
        secretWordOutput.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        secretWordOutput.setForeground(new java.awt.Color(255, 255, 255));
        secretWordOutput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        secretWordOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secretWordOutputActionPerformed(evt);
            }
        });

        guesslabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        guesslabel.setForeground(new java.awt.Color(255, 255, 255));
        guesslabel.setText("Enter Guess: ");

        userInput.setBackground(new java.awt.Color(153, 153, 153));
        userInput.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        userInput.setForeground(new java.awt.Color(255, 255, 255));
        userInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        guessBtn.setBackground(new java.awt.Color(51, 51, 51));
        guessBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        guessBtn.setForeground(new java.awt.Color(255, 255, 255));
        guessBtn.setText("Guess");
        guessBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessBtnActionPerformed(evt);
            }
        });

        newGameBtn.setBackground(new java.awt.Color(51, 51, 51));
        newGameBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        newGameBtn.setForeground(new java.awt.Color(255, 255, 255));
        newGameBtn.setText("New Game");
        newGameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameBtnActionPerformed(evt);
            }
        });

        closeGameBtn.setBackground(new java.awt.Color(51, 51, 51));
        closeGameBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        closeGameBtn.setForeground(new java.awt.Color(255, 255, 255));
        closeGameBtn.setText("Close Game");
        closeGameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeGameBtnActionPerformed(evt);
            }
        });

        outputtxt.setEditable(false);
        outputtxt.setBackground(new java.awt.Color(51, 51, 51));
        outputtxt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        outputtxt.setForeground(new java.awt.Color(255, 255, 255));
        outputtxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        outputtxt.setText("Welcome to Hangman!");

        winsOutput.setEditable(false);
        winsOutput.setBackground(new java.awt.Color(51, 51, 51));
        winsOutput.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        winsOutput.setForeground(new java.awt.Color(255, 255, 255));
        winsOutput.setText("Wins: 0");

        lossesOutput.setEditable(false);
        lossesOutput.setBackground(new java.awt.Color(51, 51, 51));
        lossesOutput.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lossesOutput.setForeground(new java.awt.Color(255, 255, 255));
        lossesOutput.setText("Losses: 0");

        nextBtn.setBackground(new java.awt.Color(51, 51, 51));
        nextBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nextBtn.setForeground(new java.awt.Color(255, 255, 255));
        nextBtn.setText("Next");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        scoreOutput.setBackground(new java.awt.Color(51, 51, 51));
        scoreOutput.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        scoreOutput.setForeground(new java.awt.Color(255, 255, 255));
        scoreOutput.setText("Score: 0");
        scoreOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreOutputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(newGameBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nextBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(secretWordOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(closeGameBtn)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(176, 176, 176)
                                        .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(166, 166, 166)
                                        .addComponent(guessBtn)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(42, 42, 42))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(winsOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lossesOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(outputtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(scoreOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(guesslabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outputtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scoreOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(winsOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lossesOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(secretWordOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(guesslabel)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newGameBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(guessBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(closeGameBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void secretWordOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secretWordOutputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secretWordOutputActionPerformed

    private void guessBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guessBtnActionPerformed
        // TODO add your handling code here:
        hangmanDisplaytxt.setText(""); // reset display
        String guess = userInput.getText().toUpperCase(); // get users guess (convert to lowercase for case insensitivity)
        
        if (secretWord.isEmpty()) { // give error message if no secret word found
            JOptionPane.showMessageDialog(null, "Please select new game first.");
            userInput.setText(""); // reset user input
            return;
        }
        
        if (guess.length() != 1 || !Character.isLetter(guess.charAt(0))) { // give error if more than one letter entered
            outputtxt.setText("Error, please enter one valid letter.");
            userInput.setText(""); // reset user input
            hangmanUpdate(); // update display so the current lives come back after error handled
            return;
        }
        
        if (guessedLetters.contains(guess)){ // show error if already guessed character entered
            outputtxt.setText("Error, " + guess + " has already been guessed.");
            userInput.setText(""); // reset user input
            hangmanUpdate(); // update display so the current lives come back after error handled
            return;
        }
        
        guessedLetters.add(guess); // add letter to guessed letters array
        
        char guessedLetter = guess.charAt(0); // get the guessed letter
    
        StringBuilder currentOutput = new StringBuilder(secretWordOutput.getText());
        boolean letterFound = false; // create boolean for letterfound
    
        // check if the guessed letter is in the secret word and replace the letter if it is
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == guessedLetter) {
            currentOutput.setCharAt(i, guessedLetter);
            letterFound = true; // found character
            outputtxt.setText("Correct guess!"); // display correct guess output
        }
    }
    
    if (!letterFound) { // if wrong letter input guesses increases
        failedGuesses += 1;
        outputtxt.setText("Incorrect guess."); // display incorrect guess
    }

    secretWordOutput.setText(currentOutput.toString()); // update the displayed word with the new StringBuilder
    userInput.setText(""); // reset userInput jtextField
    
    hangmanUpdate(); // update lives display
    
    if (failedGuesses == 7) { // 7 failed guesses = loss
        losses += 1;
        secretWordOutput.setText(secretWord.toUpperCase()); // show word
        outputtxt.setText("You Lose. Click next for new word."); // output you lose
        nextBtn.setEnabled(true);
    }
    
    if (currentOutput.indexOf("*") == -1) { // check if game is won
        wins += 1; // wins increases
        StringBuilder str5 = new StringBuilder(); // win screen
        str5.append("                        ____________\n");
        str5.append("                        |               \n");
        str5.append("                        |              \n");
        str5.append("                        |               O");
        str5.append("\n");
        str5.append("                        |              /|\\");
        str5.append("\n");
        str5.append("                    ___|___          /\\");
        str5.append("\n");
        str5.append("\n");
        str5.append("                       You got it!");
        hangmanDisplaytxt.setText(str5.toString());
        
        if (failedGuesses >= 0 && failedGuesses <= 2){ // 0 - 2 failed guesses (max points)
            points += 100; // increments points
            scoreUpdate(points); // update score output
            
        } if (failedGuesses <= 4 && failedGuesses >= 3){ // 3 - 4 failed guesses
            points += 50;
            scoreUpdate(points);
            
        } if (failedGuesses <= 8 && failedGuesses >= 5){ // 5 - 8 failed guesses
            points += 25;
            scoreUpdate(points);
        }
        
        outputtxt.setText("You Win! Click next for new word."); // output you win
        nextBtn.setEnabled(true); // enabled next button
        endScreen();
    }
    
    scoreboardUpdate(wins, losses); // update scoreboard
    
    }//GEN-LAST:event_guessBtnActionPerformed

    private void newGameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameBtnActionPerformed
        // TODO add your handling code here:
        hangmanDisplaytxt.setText("                       Good Luck !"); // display goodluck when game started
        outputtxt.setText("Welcome to hangman"); // shows welcome to hangman again if user restarts entire game
        
        nextBtn.setEnabled(false); // disable next button
        
        failedGuesses = 0; // reset all variables and guessed arraylist
        points = 0;
        wins = 0;
        losses = 0;
        guessedLetters.clear();
        
        scoreboardUpdate(wins, losses); // reset scoreboard if have too
            
        int randomIndex = (int) (Math.random() * words.size()); // get randomindex based on size of arraylist
        secretWord = words.get(randomIndex);
        words.remove(secretWord); // remove that word from list so no duplicates in one game
        secretWord = secretWord.toUpperCase(); // make the word full uppercase
            
        StringBuilder hiddenWord = new StringBuilder(); 
        for (int i = 0 ; i < secretWord.length() ; i++) {
            hiddenWord.append("*");
        }
            
        secretWordOutput.setText(hiddenWord.toString()); // set output to hidden word
    }//GEN-LAST:event_newGameBtnActionPerformed

    private void closeGameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeGameBtnActionPerformed
        // TODO add your handling code here:
        temp = temp.concat("Total Points Scored: " + points + "\n");  // create temp file with scores from last played
        temp = temp.concat("Total Games Played: " + (wins+losses) + "\n");
        temp = temp.concat("Total Wins: " + wins + "\n");
        temp = temp.concat("Total Losses: " + losses + "\n");

        double winPercent = (double) wins / (wins + losses) * 100; // calculate win percentage
        String formattedWinPercent = String.format("%.0f", winPercent); // round win percentage to no decimal places
        
        temp = temp.concat("Win Percentage = " + formattedWinPercent + "%");    
        
        FileWriter writer;
        
        try {
            writer = new FileWriter("lastscore.txt"); // create file writer to write scores into a text file
            writer.write(temp);
            writer.close();
            System.exit(0); // closes program when button clicked
        
        } catch (IOException ex) {
            Logger.getLogger(Hangman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_closeGameBtnActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        // TODO add your handling code here:
        failedGuesses = 0; // reset variables and clear arraylist
        guessedLetters.clear(); 
        secretWord = "";
        
        nextBtn.setEnabled(false); // disable next button after clicking
        
        int randomIndex = (int) (Math.random() * words.size()); // get randomindex based on size of arraylist
        secretWord = words.get(randomIndex);
        words.remove(secretWord);
        secretWord = secretWord.toUpperCase();
        
        StringBuilder hiddenWord = new StringBuilder(); // hide secret word 
            for (int i = 0 ; i < secretWord.length() ; i++) {
                hiddenWord.append("*");
            }
            
        secretWordOutput.setText(hiddenWord.toString()); // set secretWordOutput to hiddenword
        hangmanDisplaytxt.setText("                       Good Luck !"); // set output to say Good Luck
    }//GEN-LAST:event_nextBtnActionPerformed

    private void scoreOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoreOutputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scoreOutputActionPerformed

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Hangman().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeGameBtn;
    private javax.swing.JButton guessBtn;
    private javax.swing.JLabel guesslabel;
    private javax.swing.JTextArea hangmanDisplaytxt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lossesOutput;
    private javax.swing.JButton newGameBtn;
    private javax.swing.JButton nextBtn;
    private javax.swing.JTextField outputtxt;
    private javax.swing.JTextField scoreOutput;
    private javax.swing.JTextField secretWordOutput;
    private javax.swing.JTextField userInput;
    private javax.swing.JTextField winsOutput;
    // End of variables declaration//GEN-END:variables
}
