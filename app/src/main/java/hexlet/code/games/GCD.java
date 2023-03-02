package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class GCD {
    private static final int CORRECT_ANSWERS = 3;
    private static final int RANDOM_RANGE = 100;
    public static void greatestCommonDivisor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        System.out.println("Find the greatest common divisor of given numbers.");

        var sum = 0;

        while (sum < CORRECT_ANSWERS) {
            Random random = new Random();
            var firstTerm = random.nextInt(RANDOM_RANGE) + 1;
            var secondTerm = random.nextInt(RANDOM_RANGE) + 1;
            var gcd = 1;

            System.out.println("Question: " + firstTerm + " "
                    + secondTerm);
            String userAnswer = scanner.next();
            System.out.println("Your answer: "  + userAnswer);

            for (var i = 1; i <= firstTerm && i <= secondTerm; ++i) {
                if (firstTerm % i == 0 && secondTerm % i == 0) {
                    gcd = i;
                }
            }

            if (Integer.toString(gcd).equals(userAnswer)) {
                sum = sum + 1;
                System.out.println("Correct!");
                if (sum == CORRECT_ANSWERS) {
                    System.out.println("Congratulations, " + userName + "!");
                    System.exit(0);
                }

            } else {
                System.out.println("'" + userAnswer + "'"
                        + " is wrong answer ;(. Correct answer was " + "'" + gcd + "'."
                        + "\n Let's try again, " + userName + "!");
                System.exit(0);
            }
        }

    }
}
