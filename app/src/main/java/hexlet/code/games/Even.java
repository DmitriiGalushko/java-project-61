package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Even {

    private static final int CORRECT_ANSWERS = 3;
    private static final int RANDOM_RANGE = 100;
    public static void isEven() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        var sum = 0;

        while (sum < CORRECT_ANSWERS) {
            Random random = new Random();
            var randomNumber = random.nextInt(RANDOM_RANGE) + 1;
            System.out.println("Question: " + randomNumber);
            String userAnswer = scanner.next();
            System.out.println("Your answer: "  + userAnswer);

            if (randomNumber % 2 == 0 && userAnswer.equals("yes")
                    || !(randomNumber % 2 == 0) && userAnswer.equals("no")) {
                sum = sum + 1;
                System.out.println("Correct!");
                if (sum == CORRECT_ANSWERS) {
                    System.out.println("Congratulations\"Congratulations, " + userName + "!");
                    System.exit(0);
                }

            } else if (!(randomNumber % 2 == 0)  && userAnswer.equals("yes")) {
                System.out.println("'" + userAnswer + "'"
                        + " is wrong answer ;(. Correct answer was " + "'no'."
                        + "\n Let's try again, " + userName + "!");
                System.exit(0);

            } else if (randomNumber % 2 == 0 && userAnswer.equals("no")) {
                System.out.println("'" + userAnswer + "'"
                        + " is wrong answer ;(. Correct answer was " + "'yes'."
                        + "\n Let's try again, " + userName + "!");
                System.exit(0);
            } else {
                if (randomNumber % 2 == 0) {
                    System.out.println("'" + userAnswer + "'"
                            + " is wrong answer ;(. Correct answer was " + "'yes'."
                            + "\n Let's try again, " + userName + "!");
                    System.exit(0);
                } else {
                    System.out.println("'" + userAnswer + "'"
                            + " is wrong answer ;(. Correct answer was " + "'no'."
                            + "\n Let's try again, " + userName + "!");
                    System.exit(0);
                }
            }
        }

    }
}
