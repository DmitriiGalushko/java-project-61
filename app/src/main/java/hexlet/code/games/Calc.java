package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Calc {
    private static final int CORRECT_ANSWERS = 3;
    private static final int OPERAND_RANGE = 2;
    private static final int RANDOM_RANGE = 100;
    public static void calculateExpression() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        System.out.println("What is the result of the expression?");

        var sum = 0;

        while (sum < CORRECT_ANSWERS) {
            Random random = new Random();
            var firstTerm = random.nextInt(RANDOM_RANGE) + 1;
            var secondTerm = random.nextInt(RANDOM_RANGE) + 1;
            String[] operators = {"+", "-", "*"};
            var i = random.nextInt(OPERAND_RANGE + 1);

            System.out.println("Question: " + firstTerm + " "
                    + operators[i] + " " + secondTerm);
            String userAnswer = scanner.next();
            System.out.println("Your answer: "  + userAnswer);
            int result = switch (operators[i]) {
                case "+" -> firstTerm + secondTerm;
                case "-" -> firstTerm - secondTerm;
                default -> firstTerm * secondTerm;
            };

            if (Integer.toString(result).equals(userAnswer)) {
                sum = sum + 1;
                System.out.println("Correct!");
                if (sum == CORRECT_ANSWERS) {
                    System.out.println("Congratulations, " + userName + "!");
                    System.exit(0);
                }

            } else {
                System.out.println("'" + userAnswer + "'"
                        + " is wrong answer ;(. Correct answer was " + "'" + result + "'."
                        + "\n Let's try again, " + userName + "!");
                        System.exit(0);
            }
        }

    }
}

