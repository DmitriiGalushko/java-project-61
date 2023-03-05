package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;
import java.util.Scanner;

public class Prime extends Engine {
    private static final int RANDOM_RANGE = 1000;

    public Prime(String name) {
        super(name);
    }

    public final void gameRules() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    public final boolean gameRound() {
        Random random = new Random();
        var number = random.nextInt(RANDOM_RANGE) + 1;
        System.out.println("Question: " + number);
        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.next().trim().toLowerCase();
        return checkAnswer(userAnswer, getCorrectAnswer(number));
    }

    private String getCorrectAnswer(final int number) {
        return (isPrimeNumber(number)) ? "yes" : "no";
    }

    private boolean isPrimeNumber(int number) {
        for (var i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
