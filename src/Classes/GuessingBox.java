/*
Author: Reece Gavin
ID: 17197589
Last Modified: 31/03/18

Description of Class: The purpose of this clase is to create a JFrame in order to allow the users to enter their guesses.
It displays what guess it is and what their previous guesses were.
 */
package Classes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.util.Arrays;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuessingBox extends JFrame {

    public static Random randomNumber;
    public static final int Min = 1;
    public static final int Max = 500;
    public static final int totalGuesses = 10;
    public static int secretNumber;
    public static int countGuesses = 1;
    private final JTextField guessBox;
    private final JLabel pleaseInput;
    public static String str;
    public static String str2;
    public static int guesso;
    private final JLabel previousGuesses;
    private final JPanel panelForGuesses;
    private final JPanel guessboxHolder;
    private ImageIcon guessPic;
    public static int i = 0;
    public static int[] ty = new int[totalGuesses];

    public GuessingBox() {
        //Title 
        super("Guessing Game: Guess Number  " + countGuesses);

        //Create the Textfield
        guessBox = new JTextField(20);

        //Create JPanel to hold the textField
        guessboxHolder = new JPanel();
        guessboxHolder.setLayout(new FlowLayout());
        guessboxHolder.add(guessBox);

        //Create the Label
        pleaseInput = new JLabel("                         Please input your guess in the box below. Then press ENTER");
        pleaseInput.setFont(new Font("Calibri", Font.PLAIN, 16));

        //create panel for pastGuesses
        panelForGuesses = new JPanel();

        //create image
        guessPic = new ImageIcon("build/classes/Classes/thinking.jpg");
        //resize image
        Image guessPicResized = guessPic.getImage(); // transform it 
        Image newimg2 = guessPicResized.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        guessPic = new ImageIcon(newimg2);

        //Create label for previous guesses
        previousGuesses = new JLabel("<html><br>Previous guesses" + Arrays.toString(ty) + "</br></html>");
        previousGuesses.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panelForGuesses.add(previousGuesses);
        panelForGuesses.setLayout(new BoxLayout(panelForGuesses, BoxLayout.Y_AXIS));

        //add them to the frame
        add(guessboxHolder, BorderLayout.AFTER_LAST_LINE);
        add(pleaseInput, BorderLayout.PAGE_START);
        add(panelForGuesses, BorderLayout.WEST);
        add(new JLabel(new ImageIcon(newimg2)), BorderLayout.EAST);

        TextFieldHandler handler = new TextFieldHandler();
        guessBox.addActionListener(handler);

    }

    public class TextFieldHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            try {
                if (event.getSource() == guessBox) {
                    str = String.format(event.getActionCommand());

                }

                setVisible(true);
                guessBox.setText("");
                guesso = Integer.parseInt(str);
                setVisible(false);
                ty[i] = guesso;

                displayGuess.guessDisplay();

            } catch (NumberFormatException e1) { // Range check

                Exceptions.intOutofRange();
                setVisible(false);

            }
        }
    }

    public static void createBox() {
        GuessingBox inputBox = new GuessingBox();
        inputBox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inputBox.setVisible(true);
        inputBox.setSize(600, 250);

    }

}
