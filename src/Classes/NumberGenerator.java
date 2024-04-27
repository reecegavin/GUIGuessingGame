/*
Author: Reece Gavin
ID: 17197589
Last Modified: 31/03/18

Description of Class: The purpose of this clase is to create a random number between 1 and 500
 */
package Classes;

import java.util.Random;

public class NumberGenerator {

    public NumberGenerator() {

        GuessingBox.randomNumber = new Random();

    }

    public int randomGenerator(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return GuessingBox.randomNumber.nextInt((max - min) + 1) + min;

    }

    public static void makeNumber() {

        NumberGenerator secret = new NumberGenerator();
        GuessingBox.secretNumber = secret.randomGenerator(GuessingBox.Min, GuessingBox.Max);

    }
}
