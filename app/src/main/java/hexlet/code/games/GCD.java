package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;
import java.util.Scanner;

public class GCD extends Engine {
    private static final int RANDOM_RANGE = 100;

    public GCD(String name) {
        super(name);
    }

    public final void gameRules() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    public final boolean gameRound() {
        Random random = new Random();
        var firstNumber = random.nextInt(RANDOM_RANGE) + 1;
        var secondNumber = random.nextInt(RANDOM_RANGE) + 1;
        System.out.println("Question: " + firstNumber + " "
                + secondNumber);
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.next().trim().toLowerCase();
        System.out.println("Your answer: "  + userAnswer);
        return checkAnswer(userAnswer,  Integer.toString(getGcd(firstNumber, secondNumber)));
    }

    private static int getGcd(int firstNumber, int secondNumber) {
        while (firstNumber != 0 && secondNumber != 0) {
            if (firstNumber > secondNumber) {
                firstNumber %= secondNumber;
            } else {
                secondNumber %= firstNumber;
            }
        }
        return firstNumber + secondNumber;
    }
 }
