/*
Author: Reece Gavin
ID: 17197589
Last Modified: 31/03/18

Description of Class: The purpose of this clase is to create a JFrame to display the guess that the user inputted. 
It tell the user if their guess is higher, lower or correct.
 */

package Classes;

import static Classes.GuessingBox.i;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

public class displayGuess extends JFrame {

    private JLabel welcome;
    private JButton okButton;
    private String highLow;
    private ImageIcon pictureShown;

    public displayGuess() {
        super("Guessing Game");

        //Create the Jframe layout
        okButton = new JButton("Ok");
        okButton.setPreferredSize(new Dimension(150, 50));
        okButton.setFont(new Font("Calibri", Font.BOLD, 18));

        //Create Jpanels for buttons and label
        JPanel buttons = new JPanel();
        buttons.add(okButton);

        pictureShown = new ImageIcon("");

        try {
            // if guess is incorrect 
            {
                if (GuessingBox.guesso > GuessingBox.Max || GuessingBox.guesso < GuessingBox.Min) {
                    setVisible(false);
                    throw new InputMismatchException("Integer is out of range.");

                } else if (GuessingBox.guesso != GuessingBox.secretNumber) {

                    if (GuessingBox.totalGuesses == GuessingBox.countGuesses) {
                        welcome = new JLabel("         Your guess was " + GuessingBox.guesso + ". That was your last guess. The secret number was " + GuessingBox.secretNumber);
                        pictureShown = new ImageIcon("build/classes/Classes/outOfLuck.jpg");
                    } else if (GuessingBox.guesso != GuessingBox.secretNumber) {
                        if (GuessingBox.guesso > GuessingBox.secretNumber) {
                            highLow = ("Higher");
                            pictureShown = new ImageIcon("build/classes/Classes/higher.jpg");
                        }

                        if (GuessingBox.guesso < GuessingBox.secretNumber) {
                            highLow = ("Lower");
                            pictureShown = new ImageIcon("build/classes/Classes/lower.jpg");
                        }
                        welcome = new JLabel("                 Your guess was " + GuessingBox.guesso + ". This is " + highLow + " than the secret number.");

                    }

                } else if (GuessingBox.guesso == GuessingBox.secretNumber) {

                    welcome = new JLabel("                   Your guess was " + GuessingBox.guesso + ". This is the correct answer");
                    pictureShown = new ImageIcon("build/classes/Classes/correct.jpg");
                }

                Image guessPicResized = pictureShown.getImage(); // transform it 
                Image newimg3 = guessPicResized.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                pictureShown = new ImageIcon(newimg3);

                welcome.setFont(new Font("Calibri", Font.BOLD, 18));
                add(welcome, BorderLayout.PAGE_START);
                add(buttons, BorderLayout.CENTER);
                add(new JLabel(new ImageIcon(newimg3)), BorderLayout.EAST);
            }

        } catch (InputMismatchException e2) { // Something other than a number

            Exceptions.intOutofRange();
        } catch (NumberFormatException e1) { // Range check

            Exceptions.intOutofRange();
            setVisible(false);
        }
        ButtonHandler handler = new ButtonHandler();
        okButton.addActionListener(handler);
    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent click) {
            Object source = click.getSource();

            if (GuessingBox.guesso != GuessingBox.secretNumber) {

                if (source == okButton) {
                    setVisible(false);

                    if (GuessingBox.totalGuesses == GuessingBox.countGuesses) {

                        System.exit(0);
                    }
                    GuessingBox.countGuesses++;
                    GuessingBox.createBox();

                }
            }
            if (GuessingBox.guesso == GuessingBox.secretNumber) {
                if (source == okButton) {
                    System.exit(0);
                }
            }

        }

    }

    public static void guessDisplay() {

        displayGuess guess = new displayGuess();
        guess.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if (GuessingBox.guesso > GuessingBox.Max || GuessingBox.guesso < GuessingBox.Min) {
            guess.setVisible(false);
            GuessingBox.ty[i] = 0;
            GuessingBox.i = GuessingBox.i - 1;

        } else {
            guess.setVisible(true);
        }

        guess.setSize(650, 250);
        GuessingBox.i = GuessingBox.i + 1;

    }
}
