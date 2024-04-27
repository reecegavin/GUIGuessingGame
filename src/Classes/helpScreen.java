/*
Author: Reece Gavin
ID: 17197589
Last Modified: 31/03/18

Description of Class: The purpose of this clase is to create a JFrame to display a help screen to the user
 */
package Classes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

public class helpScreen extends JFrame {

    private final JLabel help;
    private final JButton okButton;

    public helpScreen() {

        super("Help");

        //Create the welcome screen text 
        help = new JLabel("<html>In this game you guess a number between 1 and 500<br>" + "\n You have " + GuessingBox.totalGuesses
                + " \n guesses to get the right answer.<br> Click OK to retun to the menu</br></br></html>");
        help.setFont(new Font("Calibri", Font.PLAIN, 16));

//Create the welcome screen buttons 
        okButton = new JButton("OK");
        okButton.setPreferredSize(new Dimension(150, 50));
        okButton.setFont(new Font("Calibri", Font.BOLD, 18));

        //Create Jpanels for buttons and label
        JPanel buttons = new JPanel();
        buttons.add(okButton);

        add(help, BorderLayout.NORTH);
        add(buttons, BorderLayout.CENTER);

        ButtonHandler handler = new ButtonHandler();

        okButton.addActionListener(handler);

    } //END OF welcomeScreen CONSTRUCTOR

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent click) {
            Object source = click.getSource();

            if (source == okButton) {
                setVisible(false);
                Application.createWelcomeScreen();
            } else {
                System.exit(0);
            }

        }
    }

    public static void callForHelp() {

        helpScreen help = new helpScreen();
        help.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        help.setVisible(true);
        help.setSize(600, 180);
    }
}
