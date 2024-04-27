/*
Author: Reece Gavin
ID: 17197589
Last Modified: 31/03/18

Description of Class: The purpose of this clase is to create a JFrame to display the initial welcome screen. 
When a button is clicked it calls the help screen, exits or else calls the method in GuessingBox class.
 */
package Classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GuessingGame extends JFrame {

    private final JLabel welcome;
    private final JButton newGame;
    private final JButton exitGame;
    private final JButton help;
    private final JPanel label1;

    public GuessingGame() {

        super("Guessing Game");

        //Create the welcome screen text 
        welcome = new JLabel("<html>Welcome to the number guessing "
                + "game.<br> In this game you guess a number between 1 and 500<br>" + "\n You have " + GuessingBox.totalGuesses
                + " \n guesses to get the right answer</br></html>");
        welcome.setFont(new Font("Calibri", Font.PLAIN, 16));

//Create the welcome screen buttons 
        newGame = new JButton("New Game");
        newGame.setPreferredSize(new Dimension(150, 50));
        newGame.setFont(new Font("Calibri", Font.BOLD, 18));
        newGame.setForeground(Color.red);
        exitGame = new JButton("Exit");
        exitGame.setPreferredSize(new Dimension(150, 50));
        exitGame.setFont(new Font("Calibri", Font.BOLD, 18));
        exitGame.setForeground(Color.orange);
        help = new JButton("Help");
        help.setPreferredSize(new Dimension(150, 50));
        help.setFont(new Font("Calibri", Font.BOLD, 18));
        help.setForeground(Color.MAGENTA);

        //Create Jpanels for buttons and label
        JPanel buttons = new JPanel();
        buttons.add(newGame);
        buttons.add(exitGame);
        buttons.add(help);
        buttons.setBackground(Color.white);

        label1 = new JPanel();
        label1.add(welcome);
        label1.setBackground(Color.white);

        add(label1, BorderLayout.PAGE_START);
        add(buttons, BorderLayout.CENTER);

        ButtonHandler handler = new ButtonHandler();
        newGame.addActionListener(handler);
        exitGame.addActionListener(handler);
        help.addActionListener(handler);

    } //END OF welcomeScreen CONSTRUCTOR

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent click) {
            Object source = click.getSource();

            if (source == newGame) {
                setVisible(false);
                GuessingBox.createBox();
            }

            if (source == exitGame) {
                System.exit(0);
            }

            if (source == help) {
                setVisible(false);
                helpScreen.callForHelp();
            }

        }
    }

    public static void createWelcomeScreen() {

        GuessingGame welcomeAll = new GuessingGame();
        welcomeAll.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeAll.setVisible(true);
        welcomeAll.setSize(600, 180);
        welcomeAll.getContentPane().setBackground(Color.white);
        
    }
}
