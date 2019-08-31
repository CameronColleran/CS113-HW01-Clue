package edu.miracosta.cs113;

/**
 * RandomClue.java : Your job is to ask your AssistantJack and get the correct
 * answer in <= 20 tries.  RandomClue is ONE solution to the problem,
 * where a set of random numbers is generated every attempt until all three
 * random numbers match the solution from the AssistantJack object.
 *
 * This is a sample solution, a driver using random number implementation.
 * You can use this file as a guide to create your own SEPARATE driver for
 * your implementation that can solve it in <= 20 times consistently.
 *
 * @author Cameron Colleran
 * @version 1.0
 *
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import model.Theory;
import model.AssistantJack;

public class MyClueSolver {

    /*
     * ALGORITHM:
     *
     * PROMPT "Which theory to test? (1, 2, 3[random]): "
     * READ answerSet
     * INSTANTIATE jack = new AssistantJack(answerSet)
     * DO
     *      weapon = random int between 1 and 6
     *      location = random int between 1 and 10
     *      murder = random int between 1 and 6
     *      solution = jack.checkAnswer(weapon, location, murder)
     * WHILE solution != 0
     *
     * OUTPUT "Total checks = " + jack.getTimesAsked()
     * IF jack.getTimesAsked() is greater than 20 THEN
     *      OUTPUT "FAILED"
     * ELSE
     *      OUTPUT "PASSED"
     * END IF
     */

    /**
     * Driver method for random guessing approach
     *
     * @param args not used for driver
     */
    public static void main(String[] args) {
        // DECLARATION + INITIALIZATION
        int answerSet, solution, murder, weapon, location;
        Theory answer;
        AssistantJack jack;
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();

        // INPUT
        System.out.println("Which theory would like you like to test? (1, 2, 3[random]): ");
        answerSet = keyboard.nextInt();
        keyboard.close();

        // PROCESSING
        jack = new AssistantJack(answerSet);

        // Algorithm: Use result of check answer to eliminate incorrect guesses by incrementing from a base of 1 on
        // all three variables, eventually will lead to the correct answer by process of elimination

        weapon = 1;
        location = 1;
        murder = 1;

        solution = jack.checkAnswer(weapon, location, murder);

        while (solution != 0)
        {
            if (solution == 1) // if answer for WEAPON is not right, increment by 1
            {
                weapon++;
            }
            else if (solution == 2) // if answer for LOCATION is not right, increment by 1
            {
                location++;
            }
            else if (solution == 3) // if answer for MURDER is not right, increment by 1
            {
                murder++;
            }
            solution = jack.checkAnswer(weapon, location, murder);
        }

        // After this series of conditionals has completed, the answer HAS to be correct by virtue of the process of
        // elimination

        answer = new Theory(weapon, location, murder);

        // OUTPUT
        System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution " + answer);

        if (jack.getTimesAsked() > 20) {
            System.out.println("FAILED!! You're a horrible Detective...");
        } else {
            System.out.println("WOW! You might as well be called Batman!");
        }

    }

}
