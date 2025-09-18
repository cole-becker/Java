import java.awt.*; //import the libraries needed in this app
import javax.swing.*; 

public class TicTac extends JFrame { //sets up our TicTac class gets access to everything in the JFrame class
    
    TicTacEvent tictac = new TicTacEvent(this); //joins the two programs (TicTac.java and TicTacEvent.java) to work with each other.

    JPanel row1 = new JPanel();  //creates a new frame
    JButton[][] boxes = new JButton[3][3]; //create a 2D grid of arrays for the 9 buttons, 
                                          //sets aside memory spots for them, but doesn't create them yet. 
                                          //The spaces have no context in them yet.

    JOptionPane win = new JOptionPane("Winner"); //will pop-up and declare the winner
    ImageIcon back = new ImageIcon("cardback.jpg");  //loads the image to be used as the background of the buttons


    public TicTac() {  //creates the method to draw the game board
        super ("Tic Tac Toe");  //creates the Title for the App
        setSize (600,620);  //sets the size of the outer frame // changed the perameters
        getContentPane().setBackground(Color.BLACK); // change color of background to black
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //sets the program to quit if the window is closed
        FlowLayout layout = new FlowLayout(); //arranges components from left to right, centering components horizontally with a five pixel gap between them.
        setLayout(layout); 
        int name = 0;  // creates a variable to keep track of box number
        String newname;

        GridLayout layout1 = new GridLayout(3, 3, 30, 30); //arranges the components in a rectangular grid, where all cells are of equal size.
        row1.setLayout(layout1);
        row1.setBackground(Color.BLACK); // change color to match blue
        for (int x=0; x<=2; x++){  //creates and adds the buttons to the GridLayout, goes up and down
            for (int y=0; y<=2; y++){  //goes across on the GridLayout
                name = name + 1; //adds one to the loop
                newname = Integer.toString(name);  //names newname from number 1-9
                boxes[x][y] = new JButton(newname);  //sets the boxes to show number 1-9
                boxes[x][y].setPreferredSize(new Dimension(150, 150)); // change size of buttons
                boxes[x][y].setIcon(back);  //sets the images of the back of the buttons
                row1.add(boxes[x][y]);  //adds remaining components to the GridLayout
            }
        }
        add (row1);  //adds the GridLayout to the FlowLayout.

        for (int x=0; x<=2; x++){  //runs a loop to see which button was pressed
            for (int y=0; y<=2; y++){
                boxes[x][y].addActionListener(tictac);  //listens to button being clicked
            }
        }

        setVisible(true);  //shows the FlowLayout on the screen.
    }

    public static void main(String[] arguments){  //this is the main method in the program and invokes all the other methods required by your program
        TicTac frame = new TicTac();  //runs the screen layout class.
    }
}
