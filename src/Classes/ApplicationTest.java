/*
Author: Reece Gavin
ID: 17197589
Last Modified: 31/03/18

Description of Class: The purpose of this clase is to run the GuessingGame class
 */


/* NORMAL TEST CASE:
User clicks new game

User inputs :
Guess 1: 55          Result: Lower
Guess 2: 150         Result: Lower
Guess 3: 200         Result: Lower
Guess 4: 300         Result: Lower
Guess 5: 350         Result: Lower 
Guess 6: 375         Result: Lower
Guess 7: 400         Result: Lower
Guess 8: 450         Result: Lower
Guess 9: 475         Result: Higher
Guess 10: 466        Result: Higher

The secret number was 466.
*/

/* Error test case: Non integer inputted
User clicks new game

User inputs :
Guess 1: 55          Result: Lower
Guess 2: 150         Result: Lower
Guess 3: kxthyg      Result: Throws exception and shows the screen asking the user to enter only integers between 1-500
Guess 3: 300         Result: Lower
Guess 4: 350         Result: Higher
Guess 5: 344         Result: Correct!



The secret number was 344.
*/

/* Error test case: Integer out of Range
User clicks new game

User inputs :
Guess 1: 55          Result: Lower
Guess 2: 150         Result: Lower
Guess 3: 5005        Result: Throws exception and shows the screen asking the user to enter only integers between 1-500
Guess 3: 300         Result: Lower
Guess 4: -600        Result: Throws exception and shows the screen asking the user to enter only integers between 1-500
Guess 4: 250         Result: Correct!

The secret number was 250.
*/
package Classes;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ApplicationTest {

    public static void main(String[] args) {

        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.out.println("Unsupported look and feel");
        }

        GuessingGame welcomeAll = new GuessingGame();
        welcomeAll.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeAll.setVisible(true);
        welcomeAll.setSize(600, 180);
        welcomeAll.getContentPane().setBackground(Color.white);
        
        NumberGenerator.makeNumber();

    }
}
