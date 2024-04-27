/*
Author: Reece Gavin
ID: 17197589
Last Modified: 31/03/18

Description of Class: The purpose of this clase is to create a JFrame to display to the user that their input is out of bounds
 */
package Classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Exceptions extends JFrame {

    private final JLabel exceptionText;
    private final JButton okButton;
    private ImageIcon uhOh;
    private final JPanel holder;
    private final JPanel buttons;

    public Exceptions() {
        super("ERROR");

        //Create the exception text and picture and button
        exceptionText = new JLabel("ERROR: Please enter only integers in the range " + GuessingBox.Min + "-" + GuessingBox.Max);
        uhOh = new ImageIcon("build/classes/Classes/404.jpg");
        okButton = new JButton("OK, let me try again");

        //create JPanels to hold text and button
        holder = new JPanel();
        buttons = new JPanel();

        //resize image
        Image uhOhresized = uhOh.getImage(); // transform it 
        Image newimg = uhOhresized.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        uhOh = new ImageIcon(newimg);

        //add button and text to panels
        holder.add(new JLabel(new ImageIcon(newimg)), BorderLayout.CENTER);
        exceptionText.setFont(new Font("Calibri", Font.BOLD, 24));
        okButton.setPreferredSize(new Dimension(300, 50));
        okButton.setFont(new Font("Calibri", Font.BOLD, 18));
        buttons.add(okButton, BorderLayout.CENTER);

        //set different colours
        holder.setBackground(Color.RED);
        okButton.setForeground(Color.blue);
        buttons.setBackground(Color.RED);
        exceptionText.setBackground(Color.RED);

        //add image,text and button to frame
        add(exceptionText, BorderLayout.PAGE_START);
        add(holder, BorderLayout.WEST);
        add(buttons, BorderLayout.CENTER);

        //declare the buttonHandler
        ButtonHandler handler = new ButtonHandler();
        okButton.addActionListener(handler);

    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent click) {
            Object source = click.getSource();

            if (source == okButton) {
                setVisible(false);
                GuessingBox.createBox();
            }
        }
    }

    public static void intOutofRange() {

        Exceptions error = new Exceptions();
        error.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        error.getContentPane().setBackground(Color.white);
        error.setVisible(true);
        error.setSize(600, 300);

    }
}
